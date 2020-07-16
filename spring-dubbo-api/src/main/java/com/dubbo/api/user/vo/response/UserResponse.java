package com.dubbo.api.user.vo.response;

import java.io.Serializable;

/**
 * <p>className: UserResponse</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-09 13:56
 */
public class UserResponse implements Serializable {

    private String userName;

    private String password;

    private String sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}