package test;

import com.creheart.domain.PlatAdmin;
import com.creheart.platform.Const.MemberConst;
import com.creheart.platform.service.AdminService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/6/4.
 */
public class AdminServiceTest extends BaseJunit{

    private Logger log = Logger.getLogger(AdminServiceTest.class);

    @Autowired
    private AdminService adminService;

    @Test
    public void testQueryList() {
        try {
            List<PlatAdmin> platAdmins = adminService.queryAdminsByName("ch");
            log.info(platAdmins);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuery() {
        try {
//            PlatAdmin platAdmin = adminService.queryAdminByName("cheng");
            PlatAdmin platAdmin = adminService.queryAdminById(0);
            log.info(platAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddAdmin() {
        try {
            PlatAdmin platAdmin = adminService.queryAdminByName("chen");
            adminService.addAdmin("LiYang", "liyang11111", MemberConst.ADMIN, MemberConst.NORMALSTATUS, platAdmin.getID());
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }

    @Test
    public void testISExistAdmin() {
        boolean result = adminService.isExistOfAdmin(3);
        System.out.println(result);
    }
}
