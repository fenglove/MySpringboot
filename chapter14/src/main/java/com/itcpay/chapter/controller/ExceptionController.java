package com.itcpay.chapter.controller;

import com.itcpay.chapter.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常演示
 */
@RestController
public class ExceptionController {

    @GetMapping("/test1")
    public String test1(Integer num) {
        if (num == null) {
            throw new CustomException(400, "num不能为空");
        }
        int i = 10/num;
        return "result:" + i;
    }

    @GetMapping("/test2")
    public String test2(Integer num) {
        int i = 10/num;
        return "result:" + i;
    }

}
