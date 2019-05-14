package com.itcpay.date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDateApplicationTests {

    @Test
    public void contextLoads() {

        HashSet<String> set = new HashSet<>();
        set.add("111");
        set.add("222");
        set.add("333");
        set.add("444");

        if (set.contains("1")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
