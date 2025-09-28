package Attestation.attestation01.repositories;

import Attestation.attestation01.model.User;
import java.util.List;

public interface UsersRepository {
    void create(User user);
    User findById(String id);
    List<User> findAll();
    void update(User user);
    void deleteById(String id);
    void deleteAll();

    // дополнительные методы:
    List<User> findByAge(int age);
    List<User> findByIsWorker(boolean isWorker);
}
