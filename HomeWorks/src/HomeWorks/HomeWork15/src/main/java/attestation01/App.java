package attestation01;

import Attestation.attestation01.model.User;
import Attestation.attestation01.repositories.UsersRepository;
import Attestation.attestation01.repositories.UsersRepositoryFileImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        UsersRepository repo = new UsersRepositoryFileImpl("demo_users.txt");

        // Пример: создать пару пользователей
        User u1 = new User();
        u1.setLogin("noisemc_99");
        u1.setPassword("pass1234");
        u1.setConfirmPassword("pass1234");
        u1.setSurname("Крылов");
        u1.setName("Виктор");
        u1.setPatronymic("Павлович");
        u1.setAge(25);
        u1.setWorker(true);

        repo.create(u1);
        System.out.println("Создан: " + u1);

        // Найти по id
        User found = repo.findById(u1.getId());
        System.out.println("Найден: " + found);

        // Показать всех
        List<User> all = repo.findAll();
        System.out.println("Всего пользователей: " + all.size());

        // Обновить
        u1.setSurname("КрыловОбновл");
        repo.update(u1);
        System.out.println("После обновления: " + repo.findById(u1.getId()));

        // Удалить
        repo.deleteById(u1.getId());
        System.out.println("Удалён пользователь с id " + u1.getId());

        // Очистить всё
        repo.deleteAll();
        System.out.println("Все пользователи удалены.");
    }
}
