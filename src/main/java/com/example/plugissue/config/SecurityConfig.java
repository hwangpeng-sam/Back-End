package com.example.plugissue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**");
    }

    // '/'와 '/main'에 대한 요첟은 누구나 할 수 있지만, 그 외의 요청은 모두 인증 후 접근 가능함.
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable() // csrf 기능을 끄라는 설정
                .authorizeRequests()
                .antMatchers("/","/main").permitAll()
                .anyRequest().authenticated();
    }
    // pw 인코더를 빈으로 등록함
    // 암호를 인코딩하거나 인코딩된 암호와 사용자가 입력한 암호가 같은지 확인할 때 사용
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
