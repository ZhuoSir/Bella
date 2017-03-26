package com.creheart.platform.processor;

import com.creheart.domain.Post;
import com.creheart.platform.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * Created by sunny on 2017/3/26.
 */
@Controller
@RequestMapping("/Admin/post")
public class PostManageProcessor {

    @Autowired
    private PostService postService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        try {
            List<Post> postList = postService.postsInRecentOneMonth();

            modelMap.addAttribute("postList", postList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("exception", e.toString());
        }
        return "/plat/post/list";
    }
}
