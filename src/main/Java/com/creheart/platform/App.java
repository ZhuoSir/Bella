package com.creheart.platform;

import com.creheart.domain.Member;
import com.creheart.platform.bean.Msg;
import com.creheart.web.service.MemberService;
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
        MemberService service = (MemberService) ctx.getBean("memberService");
        Msg msg = new Msg();
        try {
            List<Member> result = service.fuzzyQuery("18456239658", 1);
            msg.data = result;
        } catch (Exception e) {
            msg.error = e.toString();
            e.printStackTrace();
        }

        System.out.println(msg.toJson());
    }
}
