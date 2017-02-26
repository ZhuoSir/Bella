package com.creheart.platform.processor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sunny on 2017/2/26.
 */
@Controller
@RequestMapping("/main")
public class MainProcessor {

    @RequestMapping()
    public String index(ModelMap modelMap) {
        return "/plat/main";
    }

    @RequestMapping("/404")
    public String notfound() {
        return "/plat/404";
    }
}
