import com.chen.JeneralDB.DBFactory;
import org.junit.Test;

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
