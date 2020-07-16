package com.dubbo.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.dubbo.api.user.service.IUserServer;
import com.dubbo.api.user.vo.request.UserRequest;
import com.dubbo.api.user.vo.response.UserResponse;
import com.dubbo.user.dao.UserDao;
import com.dubbo.user.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>className: UserServerImpl</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-06 16:36
 */
@Service(interfaceClass = IUserServer.class)
public class UserServer implements IUserServer {

    @Override
    public void addUser(UserRequest userRequest) {
        System.out.println(JSON.toJSONString(userRequest));
        System.out.println("request = "+JSON.toJSONString(userRequest));
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest,userDto);
        userDao.registerUser(userDto);
    }

    @Autowired
    private UserDao userDao;

    @Override
    public UserResponse queryUser(UserRequest userRequest) {
        System.out.println("request = "+JSON.toJSONString(userRequest));
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(userRequest,response);
        return response;
    }
}