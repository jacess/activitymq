package com.hank.action.springRest;

import com.hank.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yangh on 15/12/21.
 */
@RestController
@RequestMapping("/services")
public class RestfulController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/user")
    public User greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setUsername(String.format(template, name));
        user.setPassword(String.valueOf(counter.incrementAndGet()));
        user.setEmail("yangh@126.com");
        return user;
    }

    @RequestMapping("/{username}")
    public User getUsername(@PathVariable String username) {
        User user = new User();
        user.setUsername(String.format(template, username));
        user.setPassword(String.valueOf(counter.incrementAndGet()));
        user.setEmail("yangh@126.com");
        return user;
    }

    /*@RequestMapping("/{serviceName}/{methodName}")
    public void getServiceName(@PathVariable String serviceName, @PathVariable String methodName, HttpServletRequest request,
                               HttpServletResponse response) {
        User user = new User();
        user.setUsername(String.format(template, serviceName));
        user.setPassword(String.valueOf(counter.incrementAndGet()));
        user.setEmail(methodName);
        outText(response,"231231231");
    }*/

    protected void outText(HttpServletResponse response, String content) {
        PrintWriter pw = null;
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-length", "" + content.getBytes("UTF-8").length);
            pw = response.getWriter();
            pw.write(content);
            pw.flush();
        } catch (Exception exp) {
            exp.printStackTrace();
            response.setStatus(407);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
