package com.creheart.processor;

import com.creheart.bean.User;
import com.creheart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by sunny on 2017/2/5.
 */
@Controller("userProcessor")
@RequestMapping("/user")
public class UserProcessor {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user) {
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
