package com.hank.dao.impl;

import com.hank.bean.User;
import com.hank.dao.UserDao;
import org.springframework.stereotype.Service;

/**
 * Created by yangh on 15/12/17.
 */
@Service
public class UserDaoImpl implements UserDao {

    public boolean checkLogin(User user) {
        return user.getUsername().equals("admin")
                && user.getPassword().equals("123");
    }
}
