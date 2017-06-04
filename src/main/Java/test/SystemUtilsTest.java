package test;

import com.creheart.platform.bean.vo.BelPostVo;
import com.creheart.platform.service.PostService;
import com.creheart.util.CacheUtils;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * Created by sunny on 2017/6/4.
 */

public class SystemUtilsTest extends BaseJunit {

    @Autowired
    private PostService postService;

    @Test
    public void test() {
        CacheManager cacheManager = CacheUtils.getXmlConfigCacheManager();

        try {
            List<BelPostVo> belPosts = postService.postsInRecentOneMonth();

            Cache<Long, BelPostVo> belPostVoCache = cacheManager.getCache("belPostCache", Long.class, BelPostVo.class);

            for (int i = 0; i < belPosts.size(); i++) {
                belPostVoCache.put((long) i, belPosts.get(i));
            }

            System.out.println(belPostVoCache.get(0L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
