package com.creheart.web.service;

import com.creheart.domain.Member;
import com.creheart.platform.Const.MemberConst;
import com.creheart.web.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny on 2017/3/3.
 */
@Component
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> allMembers() throws Exception {
        return memberRepository.allMembers();
    }

    public int forbiddenMember(String[] memberID) throws Exception {
        return memberRepository.OnOrOffMember(MemberConst.forbidden, memberID);
    }
}
