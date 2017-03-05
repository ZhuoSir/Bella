package com.creheart.platform.processor;

import com.creheart.domain.PlatFunc;
import com.creheart.platform.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/3/5.
 */
@Controller
@RequestMapping("/Admin/func")
public class PlatFuncProcessor {

    @Autowired
    private PlatformService platformService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        List<PlatFunc> platFuncs = platformService.allPlatFunces();

        modelMap.addAttribute("platFuncs", platFuncs);
        return "/plat/func/list";
    }
}
