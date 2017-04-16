package com.creheart.platform.processor;

import com.creheart.domain.BelPost;
import com.creheart.platform.bean.VO.BelPostVo;
import com.creheart.platform.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
            List<BelPostVo> postList = postService.postsInRecentOneMonth();

            modelMap.addAttribute("postList", postList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("exception", e.toString());
        }
        return "/plat/post/list";
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String query(String title, String author, Integer status, ModelMap modelMap) {
        try {
            List<BelPostVo> belPosts = postService.query(title, author, status);

            modelMap.addAttribute("postList", belPosts);
            modelMap.addAttribute("title", title);
            modelMap.addAttribute("author", author);
            modelMap.addAttribute("status", status);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("exception", e.toString());
        }

        return "/plat/post/list";
    }
}
