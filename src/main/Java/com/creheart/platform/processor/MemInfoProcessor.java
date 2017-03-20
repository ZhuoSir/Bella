package com.creheart.platform.processor;

import com.creheart.domain.Member;
import com.creheart.domain.MemberInfo;
import com.creheart.web.service.MemberService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created by sunny on 2017/3/20.
 */
@Controller
@RequestMapping("/Admin/memInfo")
public class MemInfoProcessor {

    private Logger logger = Logger.getLogger(MemInfoProcessor.class);

    @Autowired
    private MemberService memberService;

    @RequestMapping
    public String showInfoPage(String accountName, ModelMap modelMap) {
        try {
            Member     member     = memberService.queryMemberByAccountName(accountName);
            MemberInfo memberInfo = memberService.queryMemberInfoByAccountName(accountName);

            modelMap.addAttribute("member", member);
            modelMap.addAttribute("memberInfo", memberInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            modelMap.addAttribute("exception", e.toString());
        }

        return "/plat/mem/profile";
    }
}
