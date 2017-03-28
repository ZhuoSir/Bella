package com.creheart.web.service;

import com.chen.StringUtil;
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

    public Member queryMemberByID(long memberID) throws Exception {
        String sql = "select * from member where ID = ?";
        return memberRepository.query(sql, Member.class, memberID);
    }

    public Member queryMemberByAccountName(String accountName) throws Exception {
        if (!StringUtil.isNotNullOrEmpty(accountName))
            return null;

        String sql = "select * from member where accountName = ?";
        return memberRepository.query(sql, Member.class, accountName);
    }

    public MemberInfo queryMemberInfoByID(long memberID) throws Exception {
        String sql = "select * from member_info where MemberID = ?";
        return memberInfoRepository.query(sql, MemberInfo.class, memberID);
    }

    public List<Member> allMembers() throws Exception {
        return memberRepository.allMembers();
    }

    public int forbiddenMember(String memberID) throws Exception {
        if (!StringUtil.isNotNullOrEmpty(memberID))
            return -1;

        return memberRepository.OnOrOffMember(MemberConst.forbidden, memberID);
    }

    public int activeMember(String memberID) throws Exception {
        if (!StringUtil.isNotNullOrEmpty(memberID))
            return -1;

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
        sqlBuilder.append(" where ID in ( ");
        sqlBuilder.append(" select ID from member where ID like '%" + queryBuilder + "%'");
        sqlBuilder.append(" or accountID like '%" + queryBuilder +"%'");
        sqlBuilder.append(" or accountName like '%" + queryBuilder +"%'");
        sqlBuilder.append(" or email like '%" + queryBuilder +"%'");
        sqlBuilder.append(" or mobilePhone like '%" + queryBuilder +"%'");
        sqlBuilder.append(" or nickName like '%" + queryBuilder +"%'");
        sqlBuilder.append(" )");

        if (status != -1) {
            sqlBuilder.append(" and `status` = " + status + ";");
        } else {
            sqlBuilder.append(";");
        }

        return memberRepository.queryList(sqlBuilder.toString(), Member.class);
    }
}
