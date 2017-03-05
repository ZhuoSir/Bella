package com.creheart.platform.processor;

import com.creheart.domain.PlatFunc;
import com.creheart.platform.bean.PlatMenu;
import com.creheart.platform.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * Created by sunny on 2017/2/26.
 */
@Controller
@RequestMapping("/Admin/main")
public class MainProcessor {

    @Autowired
    private PlatformService platformService;

    @RequestMapping()
    public String index(ModelMap modelMap) {
        List<PlatMenu> platMenus = platformService.menuList();

        String menuHtml = getMenuHtml(platMenus);
        modelMap.addAttribute("mentHtml", menuHtml);
        return "/plat/main";
    }

    private String getMenuHtml(List<PlatMenu> platMenus) {
        StringBuilder ret = new StringBuilder("");

        if (null != platMenus && !platMenus.isEmpty()) {
            for (int i = 0, size = platMenus.size(); i < size; i++) {
                genMenuLi(platMenus.get(i), ret);
            }
        }

        return ret.toString();
    }

    private void genMenuLi(PlatMenu platMenu, StringBuilder html) {
        html.append("<li>");
        PlatFunc       theFunc    = platMenu.getPlatFunc();
        List<PlatMenu> childMenus = platMenu.getChildMenus();
        if (null != childMenus && !childMenus.isEmpty()) {
            html.append("<a href=\"javascript:void(0)\">");
            html.append("<i class=\"" + theFunc.getFuncIcon() + "\"></i>");
            html.append("<span class=\"title\">" + theFunc.getFuncName() + "</span>");
            html.append("</a>");
            for (int i = 0, size = childMenus.size(); i < size; i++) {
                html.append("<ul>");
                genMenuLi(childMenus.get(i), html);
                html.append("</ul>");
            }
        } else {
            html.append("<a href=\"javascript:void(0)\" onclick=\"redirect('/Bella/" + theFunc.getFuncUrl() + "')\">");
            html.append("<i class=\"" + theFunc.getFuncIcon() + "\"></i>");
            html.append("<span class=\"title\">" + theFunc.getFuncName() + "</span>");
            html.append("</a>");
        }
        html.append("</li>");
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "/plat/welcome";
    }

    @RequestMapping("/404")
    public String notfound() {
        return "/plat/404";
    }

    @RequestMapping("/test")
    public String test() {
        System.out.println("sucess");
        return "/plat/test/test";
    }
}
