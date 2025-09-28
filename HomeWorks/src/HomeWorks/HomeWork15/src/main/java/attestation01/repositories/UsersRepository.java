package attestation01.repositories;

import attestation01.model.User;

import java.util.List;

public interface UsersRepository {
    void create(User user);
    attestation01.model.User findById(String id);
    List<attestation01.model.User> findAll();
    void deleteById(String id);
    void deleteAll();

    // дополнительные методы:
    List<User> findByAge(int age);
    List<User> findByIsWorker(boolean isWorker);

    void update(attestation01.model.User u1);
}
