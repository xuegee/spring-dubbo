package com.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.dubbo.api.user.service.IUserServer;
import com.dubbo.api.user.vo.request.UserRequest;
import com.dubbo.api.user.vo.response.UserResponse;
import com.dubbo.vo.request.UserReqVO;
import com.dubbo.vo.response.UserRespVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Reference
    private IUserServer server;

    /**
     * @methodName addUser
     * @param
     * @describe 新增用戶
     * @author XUELIANZENG
     * @date 2020/7/17 14:48
     * @return
     */
    public void addUser(UserReqVO userReqVO){
        UserRequest request = new UserRequest();
        BeanUtils.copyProperties(userReqVO,request);
        server.registerUser(request);
    }

    /**
     * @methodName queryUser
     * @param
     * @describe 用戶查詢
     * @author XUELIANZENG
     * @date 2020/7/17 14:48
     * @return
     */
    public UserRespVO queryUser(UserReqVO userReqVO){
        UserRequest request = new UserRequest();
        UserRespVO  respVO = new UserRespVO();
        BeanUtils.copyProperties(userReqVO,request);
        UserResponse response = server.queryUser(request);
        BeanUtils.copyProperties(response,respVO);
        logger.info("response = {}" , JSON.toJSONString(respVO));
        return respVO;
    }
    /**
     * @methodName editUser
     * @param
     * @describe 修改
     * @author XUELIANZENG
     * @date 2020/7/17 14:48
     * @return
     */
    public void editUser(UserReqVO userReqVO){
        UserRequest request = new UserRequest();
        BeanUtils.copyProperties(userReqVO,request);
        server.editUser(request);
    }
}