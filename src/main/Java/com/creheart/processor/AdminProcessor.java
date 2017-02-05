package com.creheart.processor;

import com.creheart.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by sunny on 2017/2/5.
 */
@Controller("adminProcessor")
@RequestMapping("/admin")
public class AdminProcessor {

    @Resource(name = "adminService")
    private AdminService adminService;

}
