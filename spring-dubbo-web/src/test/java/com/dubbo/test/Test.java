package com.dubbo.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.api.user.service.IUserServer;
import com.dubbo.application.ApplicationWeb;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>className: Test</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-06 16:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationWeb.class)
public class Test {

    @Reference
    private IUserServer userServer;
    @org.junit.Test
    public void test1(){

    }
}