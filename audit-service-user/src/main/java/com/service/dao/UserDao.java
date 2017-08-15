package com.service.dao;

import com.base.user.User;
import com.mongo.dao.MongodbBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDao extends MongodbBaseDao<User> {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Autowired
    @Qualifier("mongoTemplate")
    @Override
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        super.mongoTemplate=mongoTemplate;
    }

}
