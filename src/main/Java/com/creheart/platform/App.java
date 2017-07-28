package com.creheart.platform;

import com.chen.JeneralDB.DBFactory;
import com.creheart.platform.service.PostService;
import com.creheart.platform.service.WebManageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 *
 * Created by sunny-chen on 2017/3/5.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        PostService postService = (PostService) ctx.getBean("postService");
////        try {
////            List<BelPost> posts = postService.postsInRecentOneMonth();
////            System.out.println(posts);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//        try {
////            postService.deleteReplyFromPost("1,3", "10001");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String[] tables = {"web_info", "web_navigation"};
//        try {
//            DBFactory.getInstance().createEntitysByTableNames(Arrays.asList(tables));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        WebManageService webManageService = (WebManageService) ctx.getBean("webManageService");

        try {
//            System.out.println(webManageService.currentWebInfo());
//            System.out.println(webManageService.webInfoOfVersion("v1.0.0"));
            System.out.println(webManageService.allNavigationInShow());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
