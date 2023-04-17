package com.example.demo.user.dao.repo;

import com.example.demo.user.dao.entity.mallUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<mallUser, Long> {


    @Query("select m from mallUser m where m.userName = :userName")
    mallUser findUserByName(@Param("userName") String userName);


    @Query("select m from mallUser m where m.userName = ?1")
    mallUser findUserByName2(String userName);

}