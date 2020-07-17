package com.dubbo.user.dao;

import com.dubbo.user.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>interfaceName: UserDao</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-16 17:32
 */

public interface UserDao {

    /**
     * @methodName registerUser
     * @param
     * @describe 用户注册
     * @author XUELIANZENG
     * @date 2020/7/17 9:48
     * @return
     */
    public void registerUser(UserDto dto);

    /**
     * @methodName editUser
     * @param
     * @describe 修改
     * @author XUELIANZENG
     * @date 2020/7/17 9:48
     * @return
     */
    public void editUser(UserDto dto);

    /**
     * @methodName queryUser
     * @param
     * @describe 查询用户
     * @author XUELIANZENG
     * @date 2020/7/17 9:48
     * @return
     */
    public UserDto queryUser(Map<String,Object> map);

}
