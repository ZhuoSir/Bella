package com.creheart.web.service;

import com.creheart.domain.Member;
import com.creheart.domain.MemberInfo;
import com.creheart.platform.Const.MemberConst;
import com.creheart.platform.repository.MemberInfoRepository;
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
    private MemberRepository     memberRepository;

    @Autowired
    private MemberInfoRepository memberInfoRepository;

    public Member queryMemberByID(int memberID) throws Exception {
        String sql = "select * from member where ID = ?";
        return memberRepository.queryBean(sql, Member.class, memberID);
    }

    public Member queryMemberByAccountName(String accountName) throws Exception {
        String sql = "select * from member where accountName = ?";
        return memberRepository.queryBean(sql, Member.class, accountName);
    }

    public MemberInfo queryMemberInfoByID(int memberID) throws Exception {
        String sql = "select * from member_info where ID = ?";
        return memberInfoRepository.queryBean(sql, MemberInfo.class, memberID);
    }

    public MemberInfo queryMemberInfoByAccountName(String accountName) throws Exception {
        String sql = "select * from member_info where accountName = ?";
        return memberInfoRepository.queryBean(sql, MemberInfo.class, accountName);
    }

    public List<Member> allMembers() throws Exception {
        return memberRepository.allMembers();
    }

    public int forbiddenMember(String memberID) throws Exception {
        return memberRepository.OnOrOffMember(MemberConst.forbidden, memberID);
    }

    public int activeMember(String memberID) throws Exception {
        return memberRepository.OnOrOffMember(MemberConst.activate, memberID);
    }

    /**
     * 模糊查询:<br>
     * <p>查询条件可以为member.ID,accountID,accountName</p>
     * <p>email,mobilePhone,nickName</p>
     *
     * @param queryBuilder 查询条件
     * @return 查询结果
     * */
    public List<Member> fuzzyQuery(String queryBuilder, int status) throws Exception {
        StringBuilder sqlBuilder = new StringBuilder(" select ID, accountID, accountName," +
                " email, addTime, status, mobilePhone, nickName from member ");
        sqlBuilder.append(" where `status` = " + status);
        sqlBuilder.append(" and ID in ( ");
        sqlBuilder.append(" select ID from member where ID like '%" + queryBuilder + "%'");
        sqlBuilder.append(" or accountID like '%" + queryBuilder +"%'");
        sqlBuilder.append(" or accountName like '%" + queryBuilder +"%'");
        sqlBuilder.append(" or email like '%" + queryBuilder +"%'");
        sqlBuilder.append(" or mobilePhone like '%" + queryBuilder +"%'");
        sqlBuilder.append(" or nickName like '%" + queryBuilder +"%'");
        sqlBuilder.append(" );");

        return memberRepository.queryBeanList(sqlBuilder.toString(), Member.class);
    }
}
