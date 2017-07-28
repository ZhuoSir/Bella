package com.creheart.web.processor;

import com.creheart.domain.Member;
import com.creheart.domain.WebNavigation;
import com.creheart.util.SessionUtil;
import com.creheart.web.service.WebBaseService;
import com.creheart.web.vo.UserFollowVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/7/27.
 */
@Controller
@RequestMapping("/index")
public class IndexProcessor {

    private Logger log = Logger.getLogger(IndexProcessor.class);

    @Autowired
    private WebBaseService webBaseService;

    @RequestMapping
    public String index(ModelMap modelMap) {

        // 获取当前用户对象
        Member user = (Member) SessionUtil.getAttributeInCurrentSession("user");
        modelMap.addAttribute("user", user);

        // 获取所有显示状态导航
        List<WebNavigation> webNavigationList = webBaseService.webNaviListOnShow();
        modelMap.addAttribute("WebNavis", webNavigationList);

        // 设置默认导航，第一个显示
        WebNavigation defaultNavi = null;
        if (webNavigationList != null && !webNavigationList.isEmpty()) {
            defaultNavi = webNavigationList.get(0);
        }
        modelMap.addAttribute("defaultNavi", defaultNavi);

        // 获取用户关注数量
        UserFollowVo userFollowVo = new UserFollowVo();
        userFollowVo.setFollowUserCount(webBaseService.countOfMemberLinkMem(user.getID()));
        userFollowVo.setStorePostCount(webBaseService.countOfMemberLinkPost(user.getID()));
        userFollowVo.setFollowLabelCount(webBaseService.countOfMemberLinkLabel(user.getID()));
        modelMap.addAttribute("userFolloVo", userFollowVo);

        return "/web/main";
    }


}
