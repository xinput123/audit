package com.rest.user;

import com.base.param.UserParam;
import com.base.po.SelectResult;
import com.base.user.User;
import com.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public SelectResult<User> insertUser(UserParam userParam){
        return userService.insertUser(userParam);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return userService.test();
    }


}
