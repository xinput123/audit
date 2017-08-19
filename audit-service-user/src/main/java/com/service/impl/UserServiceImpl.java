package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.base.param.UserParam;
import com.base.po.SelectResult;
import com.base.user.User;
import com.common.enums.ResponseEnum;
import com.common.util.MD5Utils;
import com.server.UserService;
import com.service.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserServiceImpl implements UserService{

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public SelectResult insertUser(@RequestBody UserParam userParam) {
        SelectResult sr = null;

        try{
            User user = createUserByUserParam(userParam);
            userDao.save(user);
            sr = new SelectResult(ResponseEnum.OK);
        }catch (Exception e){
            sr = new SelectResult(ResponseEnum.ERROR);
        }

        return sr;
    }

    @Override
    public String test() {
        return "adfadfadf";
    }

    private User createUserByUserParam(UserParam userParam){
        User user = new User();
        user.setUserName(userParam.getName());
        user.setLoginName(userParam.getLoginName());
        user.setEmail(userParam.getEmail());
        user.setPhone(userParam.getPhone());
        user.setPassword(MD5Utils.MD5(userParam.getPassword()));
        user.setIdCard(userParam.getIdCard());

        return user;
    }

    // 排序 <==> mysql order
    public List<Sort.Order> getOrder(String orderString){
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        List<Map> orderList = JSON.parseArray(orderString, Map.class);
        if(null!=orderList && orderList.size()>0){
            for(Map<String,String> order : orderList ){
                for(Map.Entry<String,String> map : order.entrySet()){
                    if("asc".equals(map.getValue())){
                        orders.add(new Sort.Order(Sort.Direction.ASC, map.getKey()));
                    }else {
                        orders.add(new Sort.Order(Sort.Direction.DESC, map.getKey()));
                    }
                }
            }
        }else {
            orders.add(new Sort.Order(Sort.Direction.DESC,"createDate"));
        }

        return orders;
    }
}
