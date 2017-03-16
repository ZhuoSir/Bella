package com.creheart.platform.processor;

import com.creheart.domain.Member;
import com.creheart.web.service.MemberService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * Created by sunny on 2017/3/13.
 */
@Controller
@RequestMapping("/Admin/member")
public class MemManagProcessor {

    private Logger logger = Logger.getLogger(MemManagProcessor.class);

    @Autowired
    private MemberService memberService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        List<Member> memberList = null;

        try {
            memberList = memberService.allMembers();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

        modelMap.addAttribute("memberList", memberList);
        return "/plat/mem/list";
    }

}
