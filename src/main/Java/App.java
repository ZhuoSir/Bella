import com.creheart.Jeneral.DBFactory;
import com.creheart.bean.Member;
import com.creheart.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by sunny on 2017/2/5.
 */
public class App {



    static String[] xmlPath = {
            "D:\\JAVA\\Bella\\src\\main\\resources\\applicationContext.xml",
            "D:\\JAVA\\Bella\\src\\main\\resources\\applicationContextMVC.xml"
    };

    public static void main(String[] args) throws Exception {
//        testInsert();
        testUpdate();
    }

    public static void testQuery() {
        ApplicationContext ctx     = new FileSystemXmlApplicationContext(xmlPath);
        MemberService      service = (MemberService) ctx.getBean("memberService");
        List<Member>       members = service.allMembers();

        System.out.println(members.toString());
    }

    public static void testInsert() {
        ApplicationContext ctx     = new FileSystemXmlApplicationContext(xmlPath);
        MemberService      service = (MemberService) ctx.getBean("memberService");

        Member member = new Member();
        member.setAccountID("member0001");
        member.setPassword("12345676");
        member.setMobilePhone("18745695623");
        member.setAddTime(new Date());
        member.setEmail("2653468597@qq.com");

        service.save(member);
    }

    public static void testUpdate() {
        ApplicationContext ctx     = new FileSystemXmlApplicationContext(xmlPath);
        MemberService      service = (MemberService) ctx.getBean("memberService");

        Member member = service.queryMember("1");
        member.setPassword("wertyierwwoo");
        member.setEmail("111111@qq.com");
        member.setNickName("小凤凰");

        service.update(member);
    }
}
