package com.itcpay.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // 自增id
    private Long id;
    // 账号
    private String username;
    // 密码
    private String password;
    // 角色名：shiro支持多个角色，而且接收参数也是Set<String>集合，但这里为了简单起见，定义成String类型
    private String roleName;
    // 是否禁用
    private boolean locked;

}
