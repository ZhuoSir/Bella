package com.creheart.platform.repository;

import com.chen.JeneralDB.DataTable;
import com.chen.StringUtil;
import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.BelReply;
import com.creheart.platform.Const.Constance;
import com.creheart.platform.bean.vo.BelReplyVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny on 2017/3/26.
 */
@Component
public class ReplyPostRepository extends AbstractRepository<BelReply> {

    private final String updateReplyPostSql = " update bel_reply set status = ? ";

    private final String belReplyVoSql = " select br.*, m.accountName, m.nickName from bel_reply br left join member m on br.memberID = m.ID ";

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

    public List<BelReplyVo> queryReplysOfPost(int postID, int status) throws Exception {
        StringBuilder sql = new StringBuilder(belReplyVoSql);
        sql.append(" where br.postID = ?");
        sql.append(" and br.status = ?;");

        DataTable dt = query(sql.toString(), postID, status);

        return null != dt ? dt.toBeanList(BelReplyVo.class) : null;
    }
}
