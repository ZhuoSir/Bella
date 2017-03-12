package com.creheart.platform;

import com.creheart.domain.PlatFunc;
import com.creheart.platform.repository.PlatRepository;
import com.creheart.platform.service.AdminService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sunny-chen on 2017/3/5.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService service = (AdminService) ctx.getBean("adminService");

        if (service.isExistOfAdmin("chen")) {
            System.out.println(service.validate("chen", "1111111"));
        }
    }
}
