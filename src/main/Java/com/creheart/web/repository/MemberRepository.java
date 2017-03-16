package com.creheart.web.repository;

import com.chen.JeneralDB.jdbc.Query;
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
        String sql = "select * from member ";
        return dbUtil.queryBeanList(sql, Member.class);
    }

    public List<Member> queryMembers(Query query)
            throws Exception {
        return dbUtil.queryBeanListByQuery(query, Member.class);
    }

    public int OnOrOffMember(int status, String[] memberIDs) throws Exception {
        StringBuilder ids = new StringBuilder();
        for (int i = 0; i < memberIDs.length; i++) {
            if (i > 0) ids.append(",");
            ids.append(memberIDs[i]);
        }

        String sql = "update member set status = ? where memberid in (?)";
        return dbUtil.execute(sql, status, ids.toString());
    }
}
