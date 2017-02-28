import com.chen.JeneralDB.SqlBuilder;
import com.creheart.domain.Member;
import com.creheart.domain.PlatFunc;
import com.creheart.platform.repository.PlatRepository;
import com.creheart.web.repository.MemberRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by sunny on 2017/2/5.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PlatRepository platRepository = (PlatRepository) ctx.getBean("platRepository");

        try {
            platRepository.allPlatFunces();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
