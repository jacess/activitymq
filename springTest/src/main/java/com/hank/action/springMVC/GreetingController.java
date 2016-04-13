package com.hank.action.springMVC;

import com.hank.bean.User;
import com.hank.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yangh on 15/12/21.
 */
@Controller
public class GreetingController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println(name);
        return "LoginSuccess";
    }

    @RequestMapping("/")
    public String home(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }


    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        if (userDao.checkLogin(user)) {
            model.addAttribute("username", user.getUsername());
            return "success";
        }
        return "error";
    }

}
