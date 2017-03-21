package com.creheart.web.repository;

import com.chen.JeneralDB.jdbc.Query;
import com.chen.StringUtil;
import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.Member;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny-chen on 17/2/28.
 */
@Component
public class MemberRepository extends AbstractRepository<Member> {

    public List<Member> allMembers()
            throws Exception {
        String sql = " select * from member ";
        return dbUtil.queryBeanList(sql, Member.class);
    }

    public List<Member> queryMembers(Query query)
            throws Exception {
        return dbUtil.queryBeanListByQuery(query, Member.class);
    }

    public int OnOrOffMember(int status, String memberIDs) throws Exception {
        if (!StringUtil.isNotNullOrEmpty(memberIDs))
            return -1;

        String sql = "update member set status = ? where ID in (?)";
        return dbUtil.execute(sql, status, memberIDs);
    }
}