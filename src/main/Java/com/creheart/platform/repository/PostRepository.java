package com.creheart.platform.repository;

import com.chen.JeneralDB.DataTable;
import com.chen.JeneralDB.jdbc.Query;
import com.chen.StringUtil;
import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.BelPost;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny on 2017/3/26.
 */
@Component
public class PostRepository extends AbstractRepository<BelPost> {

    public List<BelPost> queryByQuery(final Query query)
            throws Exception {
        DataTable dt = getDbUtil().queryByQuery(query);
        return null != dt ? dt.toBeanList(BelPost.class) : null;
    }


    /**
     * 修改帖子状态
     *
     * @param postID 帖子ID(可以包含多个id,id之间用`,`分割开； 例：10001,10002,10003)
     * @param status 状态值
     * */
    public int modifyStatus(final String postID, int status)
            throws Exception {
        if (StringUtil.isNullOrEmpty(postID))
            throw new IllegalArgumentException("postID不能为空");

        StringBuilder sql = new StringBuilder("update bel_post set status = ? where postID in (");
        sql.append(postID).append(")");

        return getDbUtil().execute(sql.toString(), status);
    }
}
