package com.itcpay.chapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itcpay.chapter.entity.User;
import com.itcpay.chapter.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter7ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Chapter7ApplicationTests.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user1 = new User("u1", "p1");
        User user2 = new User("u2", "p2");
        User user3 = new User("u3", "p3");

        userMapper.insertSelective(user1);
        log.info("user1回写主键-{}", user1.getId());

        userMapper.insertSelective(user2);
        log.info("user2回写主键-{}", user2.getId());

        userMapper.insertSelective(user3);
        log.info("user3回写主键-{}", user3.getId());

//        int count = userMapper.countByUsername("u1");
//        log.info("调用自己写的SQL-{}", count);

        userMapper.insertSelective(new User("uu1", "pp1"));
        userMapper.insertSelective(new User("uu2", "pp2"));
        userMapper.insertSelective(new User("uu3", "pp3"));
        userMapper.insertSelective(new User("uu4", "pp4"));
        userMapper.insertSelective(new User("uu5", "pp5"));
        userMapper.insertSelective(new User("uu6", "pp6"));
        userMapper.insertSelective(new User("uu7", "pp7"));
        userMapper.insertSelective(new User("uu8", "pp8"));
        userMapper.insertSelective(new User("uu9", "pp9"));
        userMapper.insertSelective(new User("uu10", "pp10"));

        // 分页+排序
        PageInfo<Object> pageInfo = PageHelper.startPage(1,10).setOrderBy("id desc").doSelectPageInfo(() -> this.userMapper.selectAll());

        PageHelper.startPage(1,10).setOrderBy("id desc");
        PageInfo<User> userPageInfo = new PageInfo<>(this.userMapper.selectAll());
        log.info("普通写法-{}", userPageInfo);
    }

}
