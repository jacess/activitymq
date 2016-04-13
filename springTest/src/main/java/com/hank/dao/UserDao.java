package com.hank.dao;

import com.hank.bean.User;

/**
 * Created by yangh on 15/12/15.
 */
public interface UserDao {

    boolean checkLogin(User user);
}
