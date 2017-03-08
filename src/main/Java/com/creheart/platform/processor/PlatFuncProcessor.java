package com.creheart.platform.processor;

import com.creheart.domain.PlatFunc;
import com.creheart.platform.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPlat(PlatFunc platFunc) {
        platformService.addPlatFunc(platFunc);
        return "/plat/func/list";
    }

    @RequestMapping(value = "/query")
    public String queryPlatFunc(String funcName, String parentFuncID, String status, ModelMap modelMap) {
        try {
            List<PlatFunc> platFuncs = platformService.queryPlatFunces(funcName, parentFuncID, status);
            modelMap.addAttribute("platFuncs", platFuncs);
            modelMap.addAttribute("funcName", funcName);
            modelMap.addAttribute("parentFuncID", parentFuncID);
            modelMap.addAttribute("status", status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/plat/func/list";
    }
}
