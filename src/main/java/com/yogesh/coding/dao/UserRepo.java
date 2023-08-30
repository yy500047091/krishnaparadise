package com.yogesh.coding.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yogesh.coding.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
