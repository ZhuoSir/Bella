package com.creheart.platform.processor;

import com.creheart.domain.PlatFunc;
import com.creheart.platform.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping("/edit")
    public String addPage(ModelMap modelMap) {
        try {
            List<PlatFunc> funces = platformService.allParentID();
            modelMap.addAttribute("funces", funces);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("exception", e.toString());
        }

        return "/plat/func/add";
    }

    @RequestMapping("/update")
    public String updatePage(String funcid, ModelMap modelMap) {
        try {
            PlatFunc       thePlat = platformService.queryOneById(funcid);
            List<PlatFunc> funces  = platformService.allParentID();

            modelMap.addAttribute("thePlat", thePlat);
            modelMap.addAttribute("funces", funces);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("exception", e.toString());
        }

        return "/plat/func/update";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPlat(PlatFunc platFunc) {
        platformService.addPlatFunc(platFunc);

        return "redirect:/Admin/func/list.do";
    }

    @RequestMapping(value = "/updateplat", method = RequestMethod.POST)
    public String updatePlat(PlatFunc platFunc) {
        platformService.updatePlat(platFunc);

        return "redirect:/Admin/func/list.do";
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
            modelMap.addAttribute("exception", e.toString());
        }
        return "/plat/func/list";
    }
}
