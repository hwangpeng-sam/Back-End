package com.example.plugissue.config;

//import com.example.plugissue.user.repository.JdbcUserRepository;

import com.example.plugissue.user.repository.MemoryUserRepository;
import com.example.plugissue.user.repository.UserRepository;
import com.example.plugissue.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {

    private final DataSource datasource;
    public SpringConfig(DataSource datasource) {
        this.datasource = datasource;
    }
    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }
    @Bean
    public UserRepository userRepository(){
        // return new JdbcMemberRepository(dataSource);
        return new MemoryUserRepository();
    }


}
