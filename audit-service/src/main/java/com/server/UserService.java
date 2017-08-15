package com.server;

import com.base.param.UserParam;
import com.base.po.SelectResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${audit.services.name}")
public interface UserService {
    @RequestMapping(value = "/user",method = RequestMethod.POST,consumes="application/json")
    SelectResult insertUser(@RequestBody UserParam userParam);

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String test();
}
