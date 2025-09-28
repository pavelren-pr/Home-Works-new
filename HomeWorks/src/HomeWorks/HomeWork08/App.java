package HomeWorks.HomeWork08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.util.List<Person> persons = new java.util.ArrayList<>();
        java.util.List<Product> products = new java.util.ArrayList<>();
        Path inputPath = Paths.get("input.txt");
        Path outputPath = Paths.get("output.txt");

        // Создаём файл для чтения или редактируем существующий файл
        try {
            Path filePath = Paths.get("input.txt");

            try (BufferedWriter writer = Files.newBufferedWriter(
                    filePath,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            )) {
                writer.write("Павел Андреевич = 10000\n" +
                        "Анна Петровна = 2000\n" +
                        "Борис = 10\n" +
                        "\n" +
                        "Хлеб = 40\n" +
                        "Молоко = 60\n" +
                        "Торт = 800, 15%\n" +
                        "Кофе растворимый = 432, 50%\n" +
                        "\n" +
                        "Павел Андреевич - Хлеб\n" +
                        "Павел Андреевич - Масло\n" +
                        "Анна Петровна - Кофе растворимый\n" +
                        "Анна Петровна - Молоко\n" +
                        "Анна Петровна - Молоко\n" +
                        "Анна Петровна - Молоко\n" +
                        "Анна Петровна - Торт\n" +
                        "Борис - Торт\n" +
                        "Павел Андреевич - Торт\n" +
                        "END");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get("output.txt"))) {

            // Чтение покупателей
            String line;
            while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                String[] parts = line.split("=");
                if (parts.length < 2) continue;

                String name = parts[0].trim();
                String moneyStr = parts[1].trim();

                try {
                    double money = Double.parseDouble(moneyStr);
                    persons.add(new Person(name, money));
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: сумма должна быть числом");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Чтение продуктов
            while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                if (line.contains(",") && line.contains("%")) {

                    // Обработка скидочного продукта
                    String[] parts = line.split("=", 2);
                    if (parts.length < 2) {
                        writer.write("Ошибка формата скидочного продукта: " + line + "\n");
                        continue;
                    }

                    String name = parts[0].trim();
                    String[] data = parts[1].split(",");

                    if (data.length < 2) {
                        writer.write("Ошибка формата скидки: " + line + "\n");
                        continue;
                    }

                    try {
                        double cost = Double.parseDouble(data[0].trim());
                        double discount = Double.parseDouble(data[1].replace("%", "").trim());
                        LocalDate validUntil = LocalDate.now().plusMonths(1);
                        products.add(new DiscountProduct(name, cost, discount, validUntil));
                    } catch (NumberFormatException e) {
                        writer.write("Ошибка: стоимость/скидка должны быть числами - " + line + "\n");
                    } catch (IllegalArgumentException e) {
                        writer.write(e.getMessage() + "\n");
                    }

                } else {

                    // Обработка обычного продукта
                    String[] parts = line.split("=");
                    if (parts.length < 2) {
                        writer.write("Ошибка формата: " + line + "\n");
                        continue;
                    }

                    String name = parts[0].trim();
                    String costStr = parts[1].trim();

                    try {
                        double cost = Double.parseDouble(costStr);
                        products.add(new Product(name, cost));
                    } catch (NumberFormatException e) {
                        writer.write("Ошибка: стоимость должна быть числом - " + line + "\n");
                    } catch (IllegalArgumentException e) {
                        writer.write(e.getMessage() + "\n");
                    }
                }
            }

            // Вывод каталога продуктов в файл
            writer.write("Каталог продуктов:\n");
            if (!products.isEmpty()) {
                writer.write("1. Обычные продукты:\n");
                products.stream()
                        .filter(p -> !(p instanceof DiscountProduct))
                        .forEach(p -> {
                            try {
                                writer.write("  " + p.getName() + "\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                writer.write("\n2. Акционные продукты:\n");
                products.stream()
                        .filter(p -> p instanceof DiscountProduct)
                        .forEach(p -> {
                            DiscountProduct dp = (DiscountProduct) p;
                            try {
                                writer.write(String.format("  %s (Скидка: %.0f%% до %s)%n",
                                        dp.getName(),
                                        dp.getDiscount(),
                                        dp.getValidUntil()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            } else {
                writer.write("  Продукты не добавлены!\n");
            }

            // Обработка покупок
            writer.write("\nПроцесс покупок:\n");
            while ((line = reader.readLine()) != null && !line.equals("END")) {
                String[] parts = line.split(" - ", 2);
                if (parts.length < 2) {
                    writer.write("Ошибка формата: " + line + "\n");
                    continue;
                }

                String personName = parts[0].trim();
                String productName = parts[1].trim();

                Person person = persons.stream()
                        .filter(p -> p.getName().equals(personName))
                        .findFirst()
                        .orElse(null);

                Product product = products.stream()
                        .filter(p -> p.getName().equals(productName))
                        .findFirst()
                        .orElse(null);

                if (person == null) {
                    writer.write("Покупатель не найден: " + personName + "\n");
                    continue;
                }

                if (product == null) {
                    writer.write("Продукт не найден: " + productName + "\n");
                    continue;
                }

                // Вызываем метод покупки и записываем результат
                String result = person.addProduct(product);
                writer.write(result + "\n");
            }

            // Вывод итоговой корзины
            writer.write("\nИтоговая корзина:\n");
            for (Person p : persons) {
                if (p.getProductCount() == 0) {
                    writer.write(p.getName() + " - Ничего не куплено\n");
                } else {
                    StringBuilder basketLine = new StringBuilder(p.getName() + " - ");
                    Product[] prods = p.getProductsArray();
                    for (int i = 0; i < prods.length; i++) {
                        if (i > 0) basketLine.append(", ");
                        basketLine.append(prods[i].getName());
                    }
                    writer.write(basketLine.toString() + "\n");
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}

/*
Павел Андреевич = 10000
Анна Петровна = 2000
Борис = 10

Хлеб = 40
Молоко = 60
Торт = 800, 15%
Кофе растворимый = 432, 50%

Павел Андреевич - Хлеб
Павел Андреевич - Масло
Анна Петровна - Кофе растворимый
Анна Петровна - Молоко
Анна Петровна - Молоко
Анна Петровна - Молоко
Анна Петровна - Торт
Борис - Торт
Павел Андреевич - Торт
END

2 проверка:
Женя = 0
Мороженое = 200
Женя - Мороженое
END

3 проверка:
Света = -3
Макароны = 800
Света - Макароны
END
*/
