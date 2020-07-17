package com.dubbo.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.dubbo.api.user.service.IUserServer;
import com.dubbo.api.user.vo.request.UserRequest;
import com.dubbo.api.user.vo.response.UserResponse;
import com.dubbo.common.util.ObjectUtil;
import com.dubbo.user.dao.UserDao;
import com.dubbo.user.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

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

    private static final Logger logger = LoggerFactory.getLogger(UserServer.class);

    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(UserRequest userRequest) {
        logger.info("用户注册 registerUser：{}",JSON.toJSONString(userRequest));
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest,userDto);
        userDao.registerUser(userDto);
    }

    /**
     * @param user
     * @return
     * @methodName editUser
     * @describe 用户修改
     * @author XUELIANZENG
     * @date 2020/7/17 10:02
     */
    @Override
    public void editUser(UserRequest user) {
        logger.info("用户修改 editUser：{}",JSON.toJSONString(user));
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        userDao.editUser(userDto);
    }


    @Override
    public UserResponse queryUser(UserRequest userRequest) {
        logger.info("用户查询 queryUser：{}",JSON.toJSONString(userRequest));
        Map<String,Object> searchMap = new HashMap<>();
        UserDto userDto = null;
        UserResponse response = new UserResponse();
        try {
            searchMap = ObjectUtil.convertBean(userRequest);
            userDto = userDao.queryUser(searchMap);
            if(userDto==null){
                userDto = new UserDto();
            }
            BeanUtils.copyProperties(userDto,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}