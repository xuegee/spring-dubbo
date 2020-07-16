package com.dubbo.test;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>className: DemoApplication</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-06 16:42
 */
@EnableDubbo
@SpringBootApplication
public class ApplicationUser {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationUser.class, args);
    }

}