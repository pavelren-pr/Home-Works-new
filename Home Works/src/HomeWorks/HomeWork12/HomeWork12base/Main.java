package HomeWorks.HomeWork12.HomeWork12base;

import HomeWorks.HomeWork12.HomeWork12base.exception.WrongDataFormatException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные: Фамилия Имя Отчество дд.мм.гггг(рождения) Телефон пол(f/m) возраст");
        String input = scanner.nextLine();

        String[] parts = input.split(" ");
        if (parts.length != 7) {
            System.out.println("Ошибка: неверное количество данных (ожидалось 7 полей)");
            return;
        }

        try {
            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];
            String birthDate = parts[3];
            long phone = parsePhone(parts[4]);
            char gender = parseGender(parts[5]);
            int age = parseAge(parts[6]);

            Person person = new Person(lastName, firstName, middleName, birthDate, phone, gender, age);

            saveToFile(person);
            System.out.println("✅ Данные успешно сохранены.");

        } catch (WrongDataFormatException | IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static long parsePhone(String phone) throws WrongDataFormatException {
        try {
            return Long.parseLong(phone);
        } catch (NumberFormatException e) {
            throw new WrongDataFormatException("Неверный формат телефона: " + phone);
        }
    }

    private static char parseGender(String g) throws WrongDataFormatException {
        if (g.length() == 1 && (g.equalsIgnoreCase("m") || g.equalsIgnoreCase("f"))) {
            return g.toLowerCase().charAt(0);
        }
        throw new WrongDataFormatException("Пол должен быть 'm' или 'f'");
    }

    private static int parseAge(String age) throws WrongDataFormatException {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            throw new WrongDataFormatException("Неверный формат возраста: " + age);
        }
    }

    private static void saveToFile(Person person) throws IOException {
        String dir = "Home Works/src/HomeWorks/HomeWork12/data";
        File folder = new File(dir);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String filename = dir + "/" + person.getLastName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(person.toString());
            writer.newLine();
        }
    }
}
