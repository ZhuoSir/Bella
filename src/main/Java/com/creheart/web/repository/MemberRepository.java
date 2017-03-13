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

    public List<Member> queryMembers(Query query)
            throws Exception {
        return dbUtil.queryBeanListByQuery(query, Member.class);
    }
}
