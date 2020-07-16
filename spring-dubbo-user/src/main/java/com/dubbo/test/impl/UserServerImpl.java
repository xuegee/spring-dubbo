package com.dubbo.test.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.dubbo.api.user.service.IUserServer;
import com.dubbo.api.user.vo.request.UserRequest;
import com.dubbo.api.user.vo.response.UserResponse;
import org.springframework.beans.BeanUtils;

/**
 * <p>className: UserServerImpl</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-06 16:36
 */
@Service(interfaceClass = IUserServer.class)
public class UserServerImpl implements IUserServer {

    @Override
    public void addUser(UserRequest userRequest) {
        System.out.println(JSON.toJSONString(userRequest));
    }

    @Override
    public UserResponse queryUser(UserRequest userRequest) {
        System.out.println("request = "+JSON.toJSONString(userRequest));
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(userRequest,response);
        return response;
    }
}