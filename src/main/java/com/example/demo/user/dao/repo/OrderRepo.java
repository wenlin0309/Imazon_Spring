package com.example.demo.user.dao.repo;


import com.example.demo.user.dao.entity.userOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<userOrder, Long> {
}
