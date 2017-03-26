package com.creheart.platform.service;

import com.creheart.platform.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * Created by sunny on 2017/3/26.
 */
@Component
public class PostService {

    @Autowired
    private PostRepository postRepository;
}
