import com.chen.JeneralDB.DBFactory;
import com.chen.JeneralDB.SqlBuilder;
import com.chen.StringUtil;
import com.creheart.domain.Member;
import com.creheart.domain.PlatFunc;
import com.creheart.platform.repository.PlatRepository;
import com.creheart.web.repository.MemberRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by sunny on 2017/2/5.
 */
public class App {

    @Test
    public void createEntityfromDataBase() throws Exception {
        DBFactory.getInstance().createEntityFromDataBase();
    }
}
