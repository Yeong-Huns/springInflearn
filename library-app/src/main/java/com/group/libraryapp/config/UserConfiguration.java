package com.group.libraryapp.config;

import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserConfiguration {
    @Bean
    public UserJdbcRepository repository(JdbcTemplate jdbcTemplate){
        return new UserJdbcRepository(jdbcTemplate); //
        //JdbcTemplate을 주입받은 UserRepository를 반환하고있다.
    }
}

