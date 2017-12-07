package test;

import com.creheart.domain.WebNavigation;
import com.creheart.web.service.WebBaseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/7/27.
 */
public class IndexServiceTest extends BaseJunit {

    @Autowired
    private WebBaseService indexService;

    @Test
    public void testWebNaviOnShow() {
        try {
            List<WebNavigation> webNavigations = indexService.webNaviListOnShow();
            System.out.println(webNavigations);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        System.out.println(indexService.countOfMemberLinkLabel(3L));
        System.out.println(indexService.countOfMemberLinkMem(4L));
        System.out.println(indexService.countOfMemberLinkPost(3L));
    }

    @Test
    public void test2() {
        System.out.println(indexService.popularPostsInOneWeek());
    }
}
