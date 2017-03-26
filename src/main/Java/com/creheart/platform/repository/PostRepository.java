package com.creheart.platform.repository;

import com.chen.JeneralDB.DataTable;
import com.chen.JeneralDB.jdbc.Query;
import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.Post;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by sunny on 2017/3/26.
 */
@Component
public class PostRepository extends AbstractRepository<Post> {

    public List<Post> queryByQuery(Query query)
            throws Exception {
        DataTable dt = dbUtil.queryByQuery(query);
        return null != dt ? dt.toBeanList(Post.class) : null;
    }
}
