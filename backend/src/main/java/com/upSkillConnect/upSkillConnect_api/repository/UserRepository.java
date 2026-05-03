package com.upSkillConnect.upSkillConnect_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upSkillConnect.upSkillConnect_api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}