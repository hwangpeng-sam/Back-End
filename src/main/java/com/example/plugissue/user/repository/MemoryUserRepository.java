package com.example.plugissue.user.repository;

import com.example.plugissue.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUserRepository {

    private static Map<Long, User> store = new HashMap<Long,User>();
    private static Long sequence = 0L;
//
//    @Override
//    public User save(User user) {
//        user.setId(++sequence);
//        store.put(user.getId(), user);
//        return user;
//    }
//
//    @Override
//    public Optional<User> findById(Long id) {
//        return Optional.ofNullable(store.get(id));
//    }
//
//    @Override
//    public Optional<User> findByName(String name) {
//        return store.values().stream().filter(m -> m.getName().equals(name)).findAny();
//    }
//
//    @Override
//    public List<User> findAll() {
//        return new ArrayList<User>(store.values());
//    }

}