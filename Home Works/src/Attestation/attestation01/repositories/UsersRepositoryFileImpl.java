package Attestation.attestation01.repositories;

import Attestation.attestation01.exceptions.NotFoundException;
import Attestation.attestation01.exceptions.RepositoryException;
import Attestation.attestation01.exceptions.ValidationException;
import Attestation.attestation01.model.User;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализация репозитория, хранящего пользователей в текстовом файле.
 * Каждая строка = один пользователь, поля разделяются '|':
 * id|dateTime|login|password|confirmPassword|surname|name|patronymic|age|isWorker
 */
public class UsersRepositoryFileImpl implements UsersRepository {

    private static final String DEFAULT_FILE = "users.txt";
    private final Path filePath;
    private final List<User> users = new ArrayList<>();

    public UsersRepositoryFileImpl() {
        this(DEFAULT_FILE);
    }

    // Удобно для тестов — передать временный файл
    public UsersRepositoryFileImpl(String file) {
        this.filePath = Paths.get(file);
        ensureFileExists();
        loadFromFile();
    }

    private void ensureFileExists() {
        try {
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            throw new RepositoryException("Не удалось создать файл " + filePath, e);
        }
    }

    private synchronized void loadFromFile() {
        users.clear();
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                User u = fromLine(line);
                users.add(u);
            }
        } catch (IOException e) {
            throw new RepositoryException("Ошибка чтения файла " + filePath, e);
        }
    }

    private synchronized void persistAll() {
        List<String> lines = users.stream().map(this::toLine).collect(Collectors.toList());
        try {
            Files.write(filePath, lines, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RepositoryException("Ошибка записи в файл " + filePath, e);
        }
    }

    private String toLine(User u) {
        // поля: id|dateTime|login|password|confirmPassword|surname|name|patronymic|age|isWorker
        StringBuilder sb = new StringBuilder();
        sb.append(u.getId() == null ? "" : u.getId()).append("|");
        sb.append(u.getAddedAt() == null ? "" : u.getAddedAt().toString()).append("|");
        sb.append(u.getLogin() == null ? "" : u.getLogin()).append("|");
        sb.append(u.getPassword() == null ? "" : u.getPassword()).append("|");
        sb.append(u.getConfirmPassword() == null ? "" : u.getConfirmPassword()).append("|");
        sb.append(u.getSurname() == null ? "" : u.getSurname()).append("|");
        sb.append(u.getName() == null ? "" : u.getName()).append("|");
        sb.append(u.getPatronymic() == null ? "" : u.getPatronymic()).append("|");
        sb.append(u.getAge() == null ? "" : u.getAge().toString()).append("|");
        sb.append(Boolean.toString(u.isWorker()));
        return sb.toString();
    }

    private User fromLine(String line) {
        String[] parts = line.split("\\|", -1);
        // ожидаем 10 полей
        if (parts.length < 10) {
            throw new RepositoryException("Неверный формат строки: " + line, null);
        }

        String id = parts[0];
        LocalDateTime dt = parts[1].isEmpty() ? LocalDateTime.now() : LocalDateTime.parse(parts[1]);
        String login = parts[2];
        String password = parts[3];
        String confirmPassword = parts[4];
        String surname = parts[5];
        String name = parts[6];
        String patronymic = parts[7].isEmpty() ? null : parts[7];
        Integer age = parts[8].isEmpty() ? null : Integer.valueOf(parts[8]);
        boolean isWorker = Boolean.parseBoolean(parts[9]);

        return new User(id, dt, login, password, confirmPassword, surname, name, patronymic, age, isWorker);
    }

    // Валидация требований
    private void validate(User u) {
        if (u == null) throw new ValidationException("User не может быть null");

        // id: non-null, letters and digits only
        if (u.getId() == null || u.getId().isEmpty() || !u.getId().matches("^[A-Za-z0-9\\-]+$")) {
            throw new ValidationException("Некорректный id. Должен содержать буквы/цифры (и опционально '-').");
        }

        // login: contains letters, digits, underscore; <20; not only digits
        if (u.getLogin() == null || u.getLogin().isEmpty() ||
                !u.getLogin().matches("^[A-Za-z0-9_]{1,19}$") ||
                u.getLogin().matches("^\\d+$")) {
            throw new ValidationException("Некорректный login. Должен содержать буквы/цифры/underscore, <20 символов и не состоять только из цифр.");
        }

        // password/confirmPassword: identical, contains letters/digits/underscore, <20, not only letters
        if (u.getPassword() == null || u.getConfirmPassword() == null ||
                !u.getPassword().equals(u.getConfirmPassword())) {
            throw new ValidationException("Пароли не заданы или не совпадают.");
        }
        if (!u.getPassword().matches("^[A-Za-z0-9_]{1,19}$")) {
            throw new ValidationException("Пароль должен содержать буквы/цифры/underscore и быть <20 символов.");
        }
        if (u.getPassword().matches("^[A-Za-z]+$")) {
            throw new ValidationException("Пароль не может состоять только из букв.");
        }

        // фамилия, имя, отчество - только буквы (Unicode letters). Отчество может быть null/empty
        if (u.getSurname() == null || !u.getSurname().matches("^\\p{L}+$")) {
            throw new ValidationException("Фамилия должна содержать только буквы.");
        }
        if (u.getName() == null || !u.getName().matches("^\\p{L}+$")) {
            throw new ValidationException("Имя должно содержать только буквы.");
        }
        if (u.getPatronymic() != null && !u.getPatronymic().isEmpty() && !u.getPatronymic().matches("^\\p{L}+$")) {
            throw new ValidationException("Отчество должно содержать только буквы.");
        }

        // возраст — если указан, должен быть положительным
        if (u.getAge() != null && (u.getAge() < 0 || u.getAge() > 150)) {
            throw new ValidationException("Возраст указан некорректно.");
        }
    }

    @Override
    public synchronized void create(User user) {
        // присвоить id если пустой
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(UUID.randomUUID().toString());
        }
        if (user.getAddedAt() == null) user.setAddedAt(LocalDateTime.now());

        validate(user);

        // добавить в список и дописать в файл
        users.add(user);
        try {
            Files.write(filePath, Collections.singletonList(toLine(user)), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RepositoryException("Ошибка записи при create", e);
        }
    }

    @Override
    public synchronized User findById(String id) {
        return users.stream()
                .filter(u -> u.getId() != null && u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Пользователя с заданным идентификатором не существует"));
    }

    @Override
    public synchronized List<User> findAll() {
        // возвращаем копию
        return new ArrayList<>(users);
    }

    @Override
    public synchronized void update(User user) {
        if (user.getId() == null || user.getId().isEmpty()) {
            throw new ValidationException("Для обновления нужен id пользователя.");
        }

        validate(user);

        OptionalInt idxOpt = OptionalInt.empty();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                idxOpt = OptionalInt.of(i);
                break;
            }
        }

        if (idxOpt.isPresent()) {
            users.set(idxOpt.getAsInt(), user);
            persistAll(); // полная перезапись файла
        } else {
            // при отсутствии id — создать нового пользователя (по условию)
            users.add(user);
            try {
                Files.write(filePath, Collections.singletonList(toLine(user)), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RepositoryException("Ошибка записи при update (append new)", e);
            }
        }
    }

    @Override
    public synchronized void deleteById(String id) {
        boolean removed = users.removeIf(u -> u.getId() != null && u.getId().equals(id));
        if (!removed) {
            throw new NotFoundException("Пользователя с заданным идентификатором не существует");
        }
        persistAll();
    }

    @Override
    public synchronized void deleteAll() {
        users.clear();
        persistAll();
    }

    @Override
    public synchronized List<User> findByAge(int age) {
        return users.stream().filter(u -> u.getAge() != null && u.getAge() == age).collect(Collectors.toList());
    }

    @Override
    public synchronized List<User> findByIsWorker(boolean isWorker) {
        return users.stream().filter(u -> u.isWorker() == isWorker).collect(Collectors.toList());
    }
}
