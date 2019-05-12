package com.itcpay.chapter.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * key生成器
 */
public interface CacheKeyGenerator {

    /**
     * 获取AOP参数，生成指定缓存key
     * @return
     */
    String getLockKey(ProceedingJoinPoint pjp);

}
