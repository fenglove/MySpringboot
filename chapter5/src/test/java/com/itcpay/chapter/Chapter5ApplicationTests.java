package com.itcpay.chapter;

import com.itcpay.chapter.model.User;
import com.itcpay.chapter.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter5ApplicationTests {

    private final static Logger log = LoggerFactory.getLogger(Chapter5ApplicationTests.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        User user = userRepository.save(new User("u1", "p1"));
        log.info("添加成功-{}", user);

        List<User> u1 = userRepository.findAllByUsername("u1");
        log.info("条件查询-{}", u1);

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("username")));
        Page<User> users = userRepository.findAll(pageable);
        log.info("分页+排序+查询所有-{}", users.getContent());

        userRepository.findById(users.getContent().get(0).getId()).ifPresent(user1 -> log.info("主键查询-{}", user1));

        User edit = userRepository.save(new User(user.getId(), "修改后的u1", "修改后的p1"));
        log.info("修改成功-{}", edit);

        userRepository.deleteById(user.getId());
        log.info("删除成功-{}", user.getId());
    }

}
