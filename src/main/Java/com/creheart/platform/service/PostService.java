package com.creheart.platform.service;

import com.chen.DateUtil;
import com.chen.JeneralDB.jdbc.Query;
import com.chen.StringUtil;
import com.creheart.domain.BelPost;
import com.creheart.platform.Const.Constance;
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

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReplyPostRepository replyPostRepository;

    /**
     * 近一个月内所有帖子
     *
     * */
    public List<BelPost> postsInRecentOneMonth()
            throws Exception {
        Query query = new Query();
        query.setTableName("bel_post");
        query.between("createTime",
                DateUtil.coupleOfMonthsAgo(1, "yyyy-MM-dd"),
                DateUtil.tomorrow("yyyy-MM-dd"));

        return postRepository.queryByQuery(query);
    }

    /**
     * 删除帖子，以及回复
     *
     * */
    public void deletePost(String postIDs) throws Exception {
        if (StringUtil.isNullOrEmpty(postIDs))
            return;

        replyPostRepository.deleteReplyByPostID(postIDs);
        postRepository.modifyStatus(postIDs, Constance.PostStatusDel);
    }
}
