package HomeWorks.HomeWork07;

import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.util.List<Person> persons = new java.util.ArrayList<>();
        java.util.List<Product> products = new java.util.ArrayList<>();

        System.out.println("Введите покупателей (Имя = сумма):");
        String line;
        while (!(line = scanner.nextLine().trim()).isEmpty()) {
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

        System.out.println("Введите продукты (Название = стоимость):");
        while (!(line = scanner.nextLine().trim()).isEmpty()) {

            if (line.contains(",") && line.contains("%")) {
                // Обработка скидочного продукта
                String[] parts = line.split("=", 2);
                String name = parts[0].trim();
                String[] data = parts[1].split(",");

                double cost = Double.parseDouble(data[0].trim());
                double discount = Double.parseDouble(data[1].replace("%", "").trim());
                LocalDate validUntil = LocalDate.now().plusMonths(1); // Скидка действует 1 месяц

                products.add(new DiscountProduct(name, cost, discount, validUntil));
            } else {
                // Обработка обычного продукта
                String[] parts = line.split("=");
                if (parts.length < 2) {
                    System.out.println("Ошибка: неверный формат. Правильно: 'Имя = значение'");
                    continue;
                };

                String name = parts[0].trim();
                String costStr = parts[1].trim();

                try {
                    double cost = Double.parseDouble(costStr);
                    products.add(new Product(name, cost));
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: стоимость должна быть числом");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("\nКаталог продуктов:");

        if (!products.isEmpty()) {
            // Обычные продукты
            System.out.println("Обычные продукты:");
            products.stream()
                    .filter(p -> !(p instanceof DiscountProduct))
                    .forEach(p -> System.out.println(" " + p.getName()));

            // Акционные продукты
            System.out.println("\nАкционные продукты:");
            products.stream()
                    .filter(p -> p instanceof DiscountProduct)
                    .forEach(p -> {
                        DiscountProduct dp = (DiscountProduct) p;
                        System.out.printf(" %s (Скидка: %.0f%% до %s)%n",
                                dp.getName(),
                                dp.getDiscount(),
                                dp.getValidUntil());
                    });
        } else {
            System.out.println(" Продукты не добавлены!");
        }

        System.out.println("Введите покупки (Имя - Название). END для завершения:");
        while (scanner.hasNextLine()) {
            line = scanner.nextLine().trim();
            if (line.equals("END")) break;

            String[] parts = line.split(" - ", 2);
            if (parts.length < 2) {
                System.out.println("Ошибка формата");
                continue;
            }

            String personName = parts[0].trim();
            String productName = parts[1].trim();

            Person person = null;
            for (Person p : persons) {
                if (p.getName().equals(personName)) {
                    person = p;
                    break;
                }
            }

            Product product = null;
            for (Product p : products) {
                if (p.getName().equals(productName)) {
                    product = p;
                    break;
                }
            }

            if (person == null || product == null) {
                System.out.println("Не найдено: " + line);
                continue;
            }

            person.addProduct(product);
        }

        System.out.println("\nИтоговая корзина:");
        for (Person p : persons) {
            if (p.getProductCount() == 0) {
                System.out.println(p.getName() + " - Ничего не куплено");
            } else {
                System.out.print(p.getName() + " - ");
                Product[] prods = p.getProductsArray();
                for (int i = 0; i < prods.length; i++) {
                    if (i > 0) System.out.print(", ");
                    System.out.print(prods[i].getName());
                }
                System.out.println();
            }
        }
    }
}

/*
Покупатели 1 проверка:
Павел Андреевич = 10000
Анна Петровна = 2000
Борис = 10

Продукты 1 проверка:
Хлеб = 40
Молоко = 60
Торт = 800, 15%
Кофе растворимый = 432, 50%

Покупки 1 проверка:
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
