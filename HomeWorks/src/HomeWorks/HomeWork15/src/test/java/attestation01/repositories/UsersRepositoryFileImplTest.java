package attestation01.repositories;

import Attestation.attestation01.exceptions.NotFoundException;
import Attestation.attestation01.exceptions.ValidationException;
import Attestation.attestation01.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplTest {

    private static Path tempFile;
    private UsersRepositoryFileImpl repo;

    @BeforeAll
    static void beforeAll() throws IOException {
        tempFile = Files.createTempFile("users_test", ".txt");
    }

    @BeforeEach
    void setUp() {
        repo = new UsersRepositoryFileImpl(tempFile.toString());
        repo.deleteAll();
    }

    @AfterAll
    static void afterAll() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    @Test
    void createAndFindById_success() {
        User u = new User();
        u.setLogin("ivan_01");
        u.setPassword("pwd123");
        u.setConfirmPassword("pwd123");
        u.setSurname("Иванов");
        u.setName("Иван");
        repo.create(u);

        User found = repo.findById(u.getId());
        assertNotNull(found);
        assertEquals("Иванов", found.getSurname());
    }

    @Test
    void updateExisting_success() {
        User u = new User();
        u.setLogin("masha");
        u.setPassword("mash@1"); // note: must match regex; '@' is invalid per validator -> we'll use digits/underscore only to keep valid
        // make valid:
        u.setPassword("masha123");
        u.setConfirmPassword("masha123");
        u.setSurname("Петрова");
        u.setName("Маша");
        repo.create(u);

        u.setSurname("Петрова-NEW");
        repo.update(u);

        User found = repo.findById(u.getId());
        assertEquals("Петрова-NEW", found.getSurname());
    }

    @Test
    void deleteById_notFound_throws() {
        assertThrows(NotFoundException.class, () -> repo.deleteById("no-such-id"));
    }

    @Test
    void create_invalidLogin_throwsValidation() {
        User u = new User();
        u.setLogin("123456"); // only digits => invalid
        u.setPassword("pass123");
        u.setConfirmPassword("pass123");
        u.setSurname("Сидоров");
        u.setName("Сергей");

        assertThrows(ValidationException.class, () -> repo.create(u));
    }
}
