package com.dubbo.user.boot;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
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
@EnableDubbo(scanBasePackages="com.dubbo")
@SpringBootApplication(scanBasePackages = "com.dubbo")
@MapperScan(basePackages="com.dubbo")
public class ApplicationUser {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationUser.class, args);
    }

}