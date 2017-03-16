package com.creheart.platform.processor;

import com.creheart.platform.bean.PlatMenu;
import com.creheart.platform.service.PlatformService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/3/5.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PlatformService service = (PlatformService) ctx.getBean("platformService");
        try {
            List<PlatMenu> platMenus = service.menuList();
            System.out.println(platMenus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
