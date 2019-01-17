package com.demo.dao;

import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//UserDao 继承了JpaRepository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

}