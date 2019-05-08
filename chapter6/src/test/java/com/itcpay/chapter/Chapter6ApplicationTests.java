package com.itcpay.chapter;

import com.itcpay.chapter.dao.UserMapper;
import com.itcpay.chapter.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter6ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Chapter6ApplicationTests.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        int row1 = userMapper.insertUser(new User("u1", "p1"));
        log.info("添加结果-{}", row1);

        int row2 = userMapper.insertUser(new User("u2", "p2"));
        log.info("添加结果-{}", row2);

        int row3 = userMapper.insertUser(new User("u3", "p3"));
        log.info("添加结果-{}", row3);

        List<User> u1 = userMapper.findByUsername("u1");
        log.info("根据用户名查询-{}", u1);
    }

}
