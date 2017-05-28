package com.creheart.platform.repository;

import com.chen.StringUtil;
import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.BelReply;
import com.creheart.platform.Const.Constance;
import org.springframework.stereotype.Component;

/**
 *
 * Created by sunny on 2017/3/26.
 */
@Component
public class ReplyPostRepository extends AbstractRepository<BelReply> {

    private final String updateReplyPostSql = " update bel_reply set status = ? ";

    public int deleteReply(final String replyIDs)
            throws Exception {
        return deleteTheReplysInThePost(replyIDs, null);
    }

    public int deleteTheReplysInThePost(final String replyIDs, final String postID)
            throws Exception {
        StringBuilder sql = new StringBuilder(updateReplyPostSql);

        sql.append(" where replyID in ( ").append(replyIDs).append(" )");
        if (StringUtil.isNotNullOrEmpty(postID)) {
            sql.append(" and postID = ");
            sql.append(postID);
        }
        sql.append(";");

        return getDbUtil().execute(sql.toString(), Constance.ReplyStatusDel);
    }

    public int deleteReplyByPostID(final String postIDs)
            throws Exception {
        StringBuilder sql = new StringBuilder(updateReplyPostSql);
        sql.append(" where postID in ( ").append(postIDs).append(" );");

        return getDbUtil().execute(sql.toString(), Constance.ReplyStatusDel);
    }

    public int deleteReplyByMemberID(final String memberIDs)
            throws Exception {
        StringBuilder sql = new StringBuilder(updateReplyPostSql);
        sql.append(" where memberID in (").append(memberIDs).append(");");

        return getDbUtil().execute(sql.toString(), Constance.ReplyStatusDel);
    }
}
