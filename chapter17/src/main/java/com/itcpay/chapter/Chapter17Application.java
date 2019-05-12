package com.itcpay.chapter;

import com.itcpay.chapter.interceptor.CacheKeyGenerator;
import com.itcpay.chapter.interceptor.LocalKeyGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Chapter17Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter17Application.class, args);
    }

    @Bean
    public CacheKeyGenerator cacheKeyGenerator() {
        return new LocalKeyGenerator();
    }

}
