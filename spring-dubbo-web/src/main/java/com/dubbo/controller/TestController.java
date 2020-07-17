package com.dubbo.controller;

import com.dubbo.constant.ResponseMsg;
import com.dubbo.constant.RetCode;
import com.dubbo.service.UserService;
import com.dubbo.validation.Insert;
import com.dubbo.validation.Update;
import com.dubbo.vo.request.UserReqVO;
import com.dubbo.vo.response.UserRespVO;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>className: TestController</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-06 17:42
 */
@Api(description = "用户模块",value = "用户模块",tags = "用户模块")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private UserService testService;

    /**
     * @methodName userRegister
     * @param
     * @describe 用户注册
     * @author XUELIANZENG
     * @date 2020/7/17 14:42
     * @return
     */
    @PostMapping(value = "/userRegister",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ResponseMsg<String>> userRegister(@Validated(Insert.class) @RequestBody UserReqVO userReqVO){
        testService.addUser(userReqVO);
        return new ResponseEntity<ResponseMsg<String>>(new ResponseMsg<String>(RetCode.SUCCESS.getCode(),RetCode.SUCCESS.getName()),HttpStatus.OK);
    }
    /**
     * @methodName queryUser
     * @param
     * @describe 查询用户
     * @author XUELIANZENG
     * @date 2020/7/17 14:42
     * @return
     */
    @PostMapping(value = "/queryUser",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ResponseMsg<UserRespVO>> queryUser(@RequestBody UserReqVO userReqVO){
        UserRespVO userRespVO = testService.queryUser(userReqVO);
        return new ResponseEntity<ResponseMsg<UserRespVO>>(new ResponseMsg<UserRespVO>(RetCode.SUCCESS.getCode(),RetCode.SUCCESS.getName(),userRespVO),HttpStatus.OK);
    }

    /**
     * @methodName queryUser
     * @param
     * @describe 查询用户
     * @author XUELIANZENG
     * @date 2020/7/17 14:42
     * @return
     */
    @PostMapping(value = "/editUser",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ResponseMsg<UserRespVO>> editUser(@Validated(Update.class) @RequestBody UserReqVO userReqVO){
        testService.editUser(userReqVO);
        return new ResponseEntity<ResponseMsg<UserRespVO>>(new ResponseMsg<UserRespVO>(RetCode.SUCCESS.getCode(),RetCode.SUCCESS.getName()),HttpStatus.OK);
    }

}