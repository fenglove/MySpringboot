package com.itcpay.chapter.dao;

import com.itcpay.chapter.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * t_user 操作：演示两种方式
 * 1.第一种基于mybatis3.x版本后提供的注解方式
 * 2.第二种是早期写法，将SQL写在 XML 中
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户结果集
     */
    @Select("select * from t_user where username = #{username}")
    List<User> findByUsername(@Param("username") String username);

    /**
     * 保存用户信息
     */
    int insertUser(User user);

}
