package com.itcpay.chapter.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheLock {

    /**
     * redis锁key的前缀
     */
    String prefix() default "";

    /**
     * 过期秒数，默认5秒
     */
    int expire() default 5;

    /**
     * 超时时间单位
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * key的分隔符，(默认:)
     * 生成的key N:S01008:500
     */
    String delimiter() default ":";

}
