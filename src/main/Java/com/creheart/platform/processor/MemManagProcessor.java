package com.creheart.platform.processor;

import com.alibaba.fastjson.JSON;
import com.creheart.domain.Member;
import com.creheart.platform.Const.MemberConst;
import com.creheart.platform.bean.Msg;
import com.creheart.web.service.MemberService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "query", method = RequestMethod.POST)
    public String query(String queryBuilder, int status, ModelMap modelMap) {
        List<Member> memberList = null;

        try {
            memberList = memberService.fuzzyQuery(queryBuilder, status);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

        modelMap.addAttribute("queryBuilder", queryBuilder);
        modelMap.addAttribute("status", status);
        modelMap.addAttribute("memberList", memberList);
        return "/plat/mem/list";
    }

    @RequestMapping(value = "activeOrforbid", method = RequestMethod.POST)
    public
    @ResponseBody String activeOrForbid(String memberIDs, int status) {
        Msg msg = new Msg();
        try {
            if (status == MemberConst.activate)
                msg.result = memberService.activeMember(memberIDs) > 0;

            else if (status == MemberConst.forbidden)
                msg.result = memberService.forbiddenMember(memberIDs) > 0;

        } catch (Exception e) {
            logger.error(e);
            msg.error = e.toString();
            e.printStackTrace();
        }
        return msg.toJson();
    }
}
