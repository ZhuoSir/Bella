package com.creheart.platform.repository;

import com.chen.JeneralDB.DataTable;
import com.chen.JeneralDB.jdbc.Query;
import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.Post;
import com.creheart.platform.Const.Constance;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by sunny on 2017/3/26.
 */
@Component
public class PostRepository extends AbstractRepository<Post> {

    public List<Post> queryByQuery(final Query query)
            throws Exception {
        DataTable dt = dbUtil.queryByQuery(query);
        return null != dt ? dt.toBeanList(Post.class) : null;
    }

    /**
     * 假删除：删除帖子
     *
     * post.status = -9;
     * */
    public int deletePost(final String postID)
            throws Exception {
        StringBuilder sql = new StringBuilder("update post set status = ? where postID in (");
        sql.append(postID).append(")");
        return dbUtil.execute(sql.toString(), Constance.PostStatusDel);
    }
}
