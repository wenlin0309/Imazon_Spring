package com.example.demo;

import com.example.demo.user.dao.repo.UserRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Resource
    UserRepository userRepository;

    @Test
    void testJpaInit(){
        userRepository.findById(1l);
    }

}
