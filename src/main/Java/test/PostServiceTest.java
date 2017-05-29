package test;

import com.creheart.platform.bean.vo.BelReplyVo;
import com.creheart.platform.service.PostService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/5/30.
 */
public class PostServiceTest extends BaseJunit {

    @Autowired
    PostService postService;

    @Test
    public void queryReplyTest() {
        try {
            List<BelReplyVo> replyVos = postService.queryReplyOfPostInDel(10001);
            System.out.println("Echo:-----------------------");
            System.out.println(replyVos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
