package com.creheart.platform;

import com.creheart.domain.PlatFunc;
import com.creheart.platform.repository.PlatRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sunny-chen on 2017/3/5.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PlatRepository repository = (PlatRepository) ctx.getBean("platRepository");
        try {
            PlatFunc platFunc = new PlatFunc();
            platFunc.setFuncName("测试功能3");
            repository.save("plat_func", platFunc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
