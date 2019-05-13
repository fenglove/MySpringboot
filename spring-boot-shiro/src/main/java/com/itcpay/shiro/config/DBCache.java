package com.itcpay.shiro.config;

import com.itcpay.shiro.entity.User;

import java.util.*;

/**
 * 主要不想连接数据库
 */
public class DBCache {

    /**
     * k    用户名
     * v    用户信息
     */
    public static final Map<String, User> USERS_CACHE = new HashMap<>();

    /**
     * k    角色ID
     * v    权限编码
     */
    public static final Map<String, Collection<String>> PERMISSIONS_CACHE = new HashMap<>();

    static {
        // 假设这是数据库记录
        USERS_CACHE.put("", new User(1L, "u1", "p1", "admin", true));
        USERS_CACHE.put("", new User(2L, "u2", "p2", "admin", false));
        USERS_CACHE.put("", new User(3L, "u3", "p3", "test", true));

        PERMISSIONS_CACHE.put("admin", Arrays.asList("user:list", "user:add", "user:edit"));
        PERMISSIONS_CACHE.put("test", Collections.singletonList("user:list"));
    }


}
