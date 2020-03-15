package springboot.scratch.cache;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = {"users"})
/**
 * you can define some of the cache configuration in one place — at the class level —
 * so that you won’t need to declare stuff several times.
 */
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @PostConstruct
    private void init() {
        initialize();
    }

    @Override
    public void initialize() {
        users.clear();
        users.add(User.builder().id(1L).username("admin").build());
        users.add(User.builder().id(2L).username("tester").build());
        users.add(User.builder().id(3L).username("developer").build());
    }

    @Override
    @Cacheable(key = "#id")
    /**
     * put data into cache with declared key
     */
    public User getUserById(Long id) {
        sleep();

        return users.stream().filter(user -> user.getId().longValue() == id.longValue()).findAny().orElse(null);
    }

    @Override
    @CachePut(key = "#id")
    /**
     * when method annotated with this annotation,
     * it will be executed and update the cache with given key
     */
    public User updateUserById(Long id, final String username) {
        sleep();

        Optional<User> user = users.stream().filter(u -> u.getId().longValue() == id.longValue()).findAny();
        user.ifPresent(u -> u.setUsername(username));

        return user.get();
    }

    @Override
    @Cacheable()
    /**
     * when method annotated with this annotation,
     * it will be executed only once for the given cachekey,
     * until the cache expires or gets cleared.
     */
    public List<User> getUsers() {
        sleep();

        return users;
    }

    @Override
    @CacheEvict(key = "#id")
    /**
     * this annotation clear data in cache with id key
     */
    public void deleteUserById(Long id) {
        sleep();
        Optional<User> user = users.stream().filter(u -> u.getId().longValue() == id.longValue()).findAny();
        user.ifPresent(u -> users.remove(u));
    }

    @Override
    @CacheEvict(allEntries = true)
    /**
     * this annotation clear all cache
     */
    public void clear() {
        users.clear();
    }

}
