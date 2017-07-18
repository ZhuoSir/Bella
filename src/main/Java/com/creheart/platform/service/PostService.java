package com.creheart.platform.service;

import com.chen.DateUtil;
import com.chen.JeneralDB.DataTable;
import com.chen.StringUtil;
import com.creheart.platform.Const.Constance;
import com.creheart.platform.bean.vo.BelPostVo;
import com.creheart.platform.bean.vo.BelReplyVo;
import com.creheart.platform.repository.PostRepository;
import com.creheart.platform.repository.ReplyPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny on 2017/3/26.
 */
@Component
public class PostService {

    private final String belPostVoSql  = " select bp.*, m.accountName, m.nickName from bel_post bp left join member m on bp.authorID = m.ID ";

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReplyPostRepository replyPostRepository;

    /**
     * 近一个月内所有帖子
     *
     * */
    public List<BelPostVo> postsInRecentOneMonth()
            throws Exception {
        StringBuilder sql = new StringBuilder(belPostVoSql);
        sql.append(" where bp.status = 0 and bp.createTime between ? and ? ;");

        DataTable dt = postRepository.query(sql.toString(),
                DateUtil.coupleOfMonthsAgo(1, "yyyy-MM-dd"),
                DateUtil.tomorrow("yyyy-MM-dd"));

        return null != dt ? dt.toBeanList(BelPostVo.class) : null;
    }


    /**
     * 删除帖子，以及回复
     *
     * */
    public void deletePost(String postIDs)
            throws Exception {
        if (StringUtil.isNullOrEmpty(postIDs))
            return;

        replyPostRepository.deleteReplyByPostID(postIDs);
        postRepository.modifyStatus(postIDs, Constance.PostStatusDel);
    }

    /**
     * 查询帖子
     *
     * */
    public List<BelPostVo> query(String title, String author, Integer status)
            throws Exception {
        StringBuilder sql = new StringBuilder(belPostVoSql);
        sql.append(" where 1 = 1 ");

        if (StringUtil.isNotNullOrEmpty(title)) {
            sql.append(" and bp.title like ? ");
        } else {
            title = null;
        }

        if (StringUtil.isNotNullOrEmpty(author)) {
            sql.append(" and m.accountName like ? ");
        } else {
            author = null;
        }

        sql.append(" and bp.status = ? and bp.createTime between ? and ?;");

        DataTable dt = postRepository.query(sql.toString(), title, author, status,
                DateUtil.coupleOfMonthsAgo(1, DateUtil.YEAR_MONTH_DAY_PATTERN),
                DateUtil.tomorrow(DateUtil.YEAR_MONTH_DAY_PATTERN));

        return null != dt ? dt.toBeanList(BelPostVo.class) : null;
    }

    /**
     * 查询帖子的所有显示状态回复
     *
     * @param postID 帖子ID
     *
     * */
    public List<BelReplyVo> queryReplyOfPostInShow(int postID) throws Exception {
        return replyPostRepository.queryReplysOfPost(postID, Constance.ReplyStatusNormal);
    }

    /**
     * 查询帖子的所有删除状态回复
     *
     * @param postID 帖子ID
     *
     * */
    public List<BelReplyVo> queryReplyOfPostInDel(int postID) throws Exception {
        return replyPostRepository.queryReplysOfPost(postID, Constance.ReplyStatusDel);
    }

    /**
     * 删除指定帖子的特定回复
     *
     * */
    public int deleteTheReplyOfThePost(String postID, String replyIDs) throws Exception {
        return replyPostRepository.deleteTheReplysInThePost(replyIDs, postID);
    }
}
