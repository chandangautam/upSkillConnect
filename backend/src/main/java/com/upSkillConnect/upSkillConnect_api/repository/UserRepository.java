package com.upSkillConnect.upSkillConnect_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upSkillConnect.upSkillConnect_api.entity.User;
import com.upSkillConnect.upSkillConnect_api.entity.enums.Role;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    List<User> findByRole(Role role);
}