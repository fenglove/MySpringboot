package com.itcpay.chapter.mapper;

import com.itcpay.chapter.entity.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 根据用户名统计
    int countByUsername(String username);

}
