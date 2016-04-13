package com.hank.action.struts;

import com.hank.bean.User;
import com.hank.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangh on 15/12/15.
 */

@Service
public class LoginAction extends ActionSupport {

    @Autowired
    private UserDao userDao;

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String execute() {

        if (userDao.checkLogin(user)) {
            return SUCCESS;
        }
        return ERROR;
    }
}
