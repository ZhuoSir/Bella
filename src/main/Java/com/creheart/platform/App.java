package com.creheart.platform;

import com.creheart.domain.BelPost;
import com.creheart.platform.service.PostService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/3/5.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PostService postService = (PostService) ctx.getBean("postService");
        try {
            List<BelPost> posts = postService.postsInRecentOneMonth();
            System.out.println(posts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
