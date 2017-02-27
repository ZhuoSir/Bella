import com.chen.JeneralDB.SqlBuilder;
import com.creheart.domain.Member;

/**
 *
 * Created by sunny on 2017/2/5.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Member member = new Member();
        member.setID(10001);
        member.setAccountID("chen1111");
        System.out.println(SqlBuilder.buildDeleteSql(member));
    }
}
