package test;

import com.creheart.domain.PlatAdmin;
import com.creheart.domain.WebNavigation;
import com.creheart.platform.Const.Constance;
import com.creheart.platform.repository.AdminRepository;
import com.creheart.platform.service.WebManageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by sunny-chen on 2017/5/28.
 */
public class WebManageServiceTest extends BaseJunit {

    @Autowired
    private WebManageService webManageService;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void queryAllNavi() {
        try {
            System.out.println("echo: " + webManageService.allNavigationInHidden());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createNewNavi() {
        try {
            PlatAdmin admin = adminRepository.queryAdminByName("chen");
            System.out.println(webManageService.createNewNavigation("Java", admin.getID(), Constance.NaviStatusShow));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createNewNavi2() {
        try {
            PlatAdmin admin = adminRepository.queryAdminByName("chen");
            WebNavigation navi = new WebNavigation();
            navi.setId(2);
            navi.setManagerID(admin.getID());
            navi.setTitle("Python");
            navi.setStatus(Constance.NaviStatusHidden);

            System.out.println(webManageService.createNewNavigation(navi));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteNavi() {
        try {
            System.out.println(webManageService.deleteNavigation(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
