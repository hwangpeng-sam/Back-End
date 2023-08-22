package com.example.plugissue.user;

import com.example.plugissue.user.domain.User;
import com.example.plugissue.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDao {
    @Autowired
    private UserRepository repository;

    public User save(User user) {
        repository.save(user);

        return user;
    }
    public List<User> getAllUsers(){
        List<User> users=new ArrayList<>();
        Streamable.of(repository.findAll()).
                forEach(users::add);

        return users;
    }
    public void delete(User user){
        repository.delete(user);
    }

    public void deleyeByid(String id){
        repository.deleteById(id);
    }



}
