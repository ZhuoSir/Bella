package com.creheart.service;

import com.creheart.bean.Member;
import com.creheart.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunny on 2017/2/6.
 */
@Service("memberService")
public class MemberService {

    @Resource(name = "memberRepository")
    private MemberRepository memberRepository;

    public int save(Member member) {
        return memberRepository.save(member);
    }

    public int update(Member member) {
        return memberRepository.update(member);
    }

    public List<Member> allMembers() {
        return memberRepository.allMembers();
    }

    public Member queryMember(String id) {
        return memberRepository.queryOneById(id);
    }

    public List<Member> queryMembers() {
        return null;
    }
}
