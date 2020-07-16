package com.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.dubbo.api.user.service.IUserServer;
import com.dubbo.api.user.vo.request.UserRequest;
import com.dubbo.api.user.vo.response.UserResponse;
import com.dubbo.vo.request.UserReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * <p>className: TestService</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-06 17:45
 */
@Component
public class UserService {

    @Reference
    private IUserServer server;

    public void addUser(UserReqVO userReqVO){
        UserRequest request = new UserRequest();
        BeanUtils.copyProperties(userReqVO,request);
        server.addUser(request);
    }

    public void queryUser(String name){
        UserRequest request = new UserRequest();
        UserResponse response = server.queryUser(request);
        System.out.println("response = " + JSON.toJSONString(response));
    }
}