package com.itcpay.chapter.controller;

import com.itcpay.chapter.annotation.DateTime;
import com.itcpay.chapter.groups.Groups;
import com.itcpay.chapter.pojo.Book;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @Validated 添加在类上即为验证方法，添加在方法参数中即为校验参数对象（添加在方法上无效）
 */
//@Validated
@RestController
public class ValidateController {

    // 简单的数据校验
    @GetMapping("/test1")
    public String test1(@NotBlank(message = "name 不能为空")
                            @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max}之间")
                                    String name) {
        return "success";
    }

    @GetMapping("/test2")
    public String test2(@Validated Book book) {
        return "success";
    }

    // 自定义注解进行数据校验
    @GetMapping("/test3")
    public String test3(@DateTime(message = "您输入的格式错误，正确的格式为：{format}", format = "yyyy-MM-dd HH:mm") String date) {
        return "success";
    }

    // 自定义注解增加分组进行数据校验
    @GetMapping("/insert")
    public String insert(@Validated(value = Groups.Default.class) Book book) {
        return "insert";
    }

    @GetMapping("/update")
    public String update(@Validated(value = {Groups.Default.class, Groups.Update.class}) Book book) {
        return "update";
    }

}
