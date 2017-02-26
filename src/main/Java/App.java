import com.chen.JeneralDB.DBFactory;

/**
 * Created by sunny on 2017/2/5.
 */
public class App {

    public static void main(String[] args) throws Exception {
        DBFactory.getInstance().createEntityFromDataBase();
    }
}
