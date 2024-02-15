package com.xuanphi.securityjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xuanphi.securityjpa.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
