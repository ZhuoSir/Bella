import com.creheart.bean.User;
import com.creheart.service.UserService;
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

//        DBFactory dbFactory = DBFactory.getInstance();
//        dbFactory.createEntityFromDataBase();

        User user = new User();
        user.setAccountID("user10001");
        user.setNickName("chenzhuo");
        user.setAccountName("wangzhe");
        user.setAddTime(new Date());
        user.setMobilePhone("18545461989");


        ApplicationContext context = new FileSystemXmlApplicationContext(xmlPath);
        UserService service = (UserService) context.getBean("userService");
//        service.save(user);
//        List<User> ret = service.allUser();
//        ret.forEach(user1 -> System.out.println(user.toString()));
    }
}
