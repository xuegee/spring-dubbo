package com.dubbo.vo.request;

import com.dubbo.validation.Insert;
import com.dubbo.validation.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>className: UserReqVO</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-16 11:05
 */
@ApiModel(description = "请求数据", value = "请求类")
public class UserReqVO implements Serializable {

    @NotNull(message = "姓名不可以为空",groups = Update.class)
    @ApiModelProperty(value = "主鍵",required = true)
    private int id;
    @NotNull(message = "姓名不可以为空",groups ={Insert.class,Update.class} )
    @ApiModelProperty(value = "姓名",required = true)
    private String name;
    @NotNull(message = "密码不可以为空",groups ={Insert.class,Update.class})
    @ApiModelProperty(value = "密码",required = true)
    private String passwd;
    @NotNull(message = "性别不可以为空",groups ={Insert.class,Update.class})
    @ApiModelProperty(value = "性别",required = true)
    private String sex;
    @NotNull(message = "证件号不可以为空",groups ={Insert.class,Update.class})
    @ApiModelProperty(value = "证件号",required = true)
    private String cardId;
    @ApiModelProperty(value = "年龄")
    private String age;
    @ApiModelProperty(value = "邮箱")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}