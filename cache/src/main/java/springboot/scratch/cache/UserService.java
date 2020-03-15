package springboot.scratch.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface UserService {

    User getUserById(Long id);

    User updateUserById(Long id, String username);

    List<User> getUsers();

    void deleteUserById(Long id);

    void clear();

    void initialize();

    default void sleep() {
        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
