package com.dubbo.user.dao;

import com.dubbo.user.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * <p>interfaceName: UserDao</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-16 17:32
 */

public interface UserDao {

    public void registerUser(UserDto dto);

}
