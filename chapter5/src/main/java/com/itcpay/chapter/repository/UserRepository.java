package com.itcpay.chapter.repository;

import com.itcpay.chapter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 根据用户名查询用户信息
    List<User> findAllByUsername(String username);

}
