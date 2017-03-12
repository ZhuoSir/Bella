package com.creheart.platform.processor;

import com.alibaba.fastjson.JSON;
import com.creheart.platform.bean.Msg;
import com.creheart.platform.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * Created by sunny-chen on 2017/3/11.
 */
@Controller
@RequestMapping("/Admin/admin")
public class AdminProcessor {

    @Autowired
    private AdminService adminService;

    @RequestMapping
    public String index() {
        return "/plat/login";
    }

    @RequestMapping(value = "/login")
    public
    @ResponseBody String login(String username, String pwd, ModelMap modelMap) {
        Msg msg = new Msg();
        msg.result = false;

        if (adminService.isExistOfAdmin(username)) {
            String validate = adminService.validate(username, pwd);
            if ("success".equals(validate)) {
                adminService.loginService(username);
                msg.result  = true;
            } else if ("fail".equals(validate)) {
                msg.message = "登录密码错误！";
            } else {
                msg.message = validate;
            }

        } else {
            msg.message = "用户不存在！";
        }

        return JSON.toJSONString(msg);
    }

}
