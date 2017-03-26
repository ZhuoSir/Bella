package com.creheart.platform.service;

import com.chen.DateUtil;
import com.chen.JeneralDB.jdbc.Query;
import com.creheart.domain.Post;
import com.creheart.platform.repository.PostRepository;
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

    /**
     * 近一个月内所有帖子
     *
     * */
    public List<Post> postsInRecentOneMonth()
            throws Exception {
        Query query = new Query();
        query.setTableName("post");
        query.between("createTime",
                DateUtil.coupleOfMonthsAgo(6, "yyyy-MM-dd"),
                DateUtil.tomorrow("yyyy-MM-dd"));

        return postRepository.queryByQuery(query);
    }

    public int addPost(Post post)
            throws Exception {
        return postRepository.save(post);
    }
}
