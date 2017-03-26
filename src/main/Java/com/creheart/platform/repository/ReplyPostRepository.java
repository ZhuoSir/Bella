package com.creheart.platform.repository;

import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.ReplyInPost;
import com.creheart.platform.Const.Constance;
import org.springframework.stereotype.Component;

/**
 *
 * Created by sunny on 2017/3/26.
 */
@Component
public class ReplyPostRepository extends AbstractRepository<ReplyInPost> {

    private final String updateReplyPostSql = " update reply_in_post set status = ? ";

    public int deleteReply(final String replyIDs)
            throws Exception {
        StringBuilder sql = new StringBuilder(updateReplyPostSql);
        sql.append(" where replyID in ( ").append(replyIDs).append(" );");

        return dbUtil.execute(sql.toString(), Constance.ReplyStatusDel);
    }

    public int deleteReplyByPostID(final String postIDs)
            throws Exception {
        StringBuilder sql = new StringBuilder(updateReplyPostSql);
        sql.append(" where postID in ( ").append(postIDs).append(" );");

        return dbUtil.execute(sql.toString(), Constance.ReplyStatusDel);
    }

    public int deleteReplyByMemberID(final String memberIDs)
            throws Exception {
        StringBuilder sql = new StringBuilder(updateReplyPostSql);
        sql.append(" where memberID in (").append(memberIDs).append(");");

        return dbUtil.execute(sql.toString(), Constance.ReplyStatusDel);
    }
}
