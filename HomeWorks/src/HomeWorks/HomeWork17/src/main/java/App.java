import org.flywaydb.core.Flyway;

public class App {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432", "postgres", "postgres")
                .load();

        flyway.migrate();
        System.out.println("✅ Миграции успешно применены!");
    }
}