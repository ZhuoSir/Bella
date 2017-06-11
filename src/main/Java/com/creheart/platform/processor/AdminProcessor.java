package com.creheart.platform.processor;

import com.creheart.platform.bean.Msg;
import com.creheart.platform.exception.ServiceException;
import com.creheart.platform.service.AdminService;
import com.creheart.util.SessonUtil;
import org.apache.log4j.Logger;
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

    private Logger log = Logger.getLogger(AdminProcessor.class);

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

        try {
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
        } catch (ServiceException e) {
            log.error(e);
            e.printStackTrace();
            msg.message = e.getMessage();
        }

        return msg.toJson();
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        SessonUtil.removeAttributeInCurrentSession("platAdmin");
        return "redirect:/Admin/main.do";
    }
}
