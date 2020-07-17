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

    /**
     * @methodName registerUser
     * @param
     * @describe 用户注册
     * @author XUELIANZENG
     * @date 2020/7/17 10:02
     * @return
     */
    public void registerUser(UserRequest user);
    /**
     * @methodName editUser
     * @param
     * @describe 用户修改
     * @author XUELIANZENG
     * @date 2020/7/17 10:02
     * @return
     */
    public void editUser(UserRequest user);

    /**
     * @methodName queryUser
     * @param
     * @describe 查询用户
     * @author XUELIANZENG
     * @date 2020/7/17 10:02
     * @return
     */
    public UserResponse queryUser(UserRequest userRequest);

}
