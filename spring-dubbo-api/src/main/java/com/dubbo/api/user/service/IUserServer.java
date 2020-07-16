package com.dubbo.api.user.service;

import com.dubbo.api.user.vo.request.UserRequest;
import com.dubbo.api.user.vo.response.UserResponse;

/**
 * <p>interfaceName: IUserServer</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-03 16:11
 */

public interface IUserServer {

    public void addUser(UserRequest user);

    public UserResponse queryUser(UserRequest userRequest);

}
