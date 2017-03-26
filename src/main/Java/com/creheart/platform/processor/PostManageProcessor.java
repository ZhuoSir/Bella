package com.creheart.platform.processor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created by sunny on 2017/3/26.
 */
@Controller
@RequestMapping("/Admin/post")
public class PostManageProcessor {

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        return "";
    }

}
