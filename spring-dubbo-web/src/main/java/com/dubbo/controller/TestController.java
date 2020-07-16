package com.dubbo.controller;

import com.dubbo.service.UserService;
import com.dubbo.vo.request.UserReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>className: TestController</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-06 17:42
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private UserService testService;

    @PostMapping(value = "/userRegister",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> userRegister(@RequestBody UserReqVO userReqVO){
        testService.addUser(userReqVO);
        return new ResponseEntity<String>("OK",HttpStatus.OK);
    }
    @GetMapping(value = "/queryUser")
    public String queryUser(String name){
        testService.queryUser(name);
        return "success !";
    }

}