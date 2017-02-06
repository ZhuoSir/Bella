package com.creheart.repository;

import com.creheart.Jeneral.DBUtil;
import com.creheart.bean.Member;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunny on 2017/2/6.
 */
@Repository("memberRepository")
public class MemberRepository {

    private Logger logger = Logger.getLogger(MemberRepository.class);

    private DBUtil dbUtil = DBUtil.getInstance();

    public int save(Member member) {
        int ret = -1;

        try {
            dbUtil.transBegin();
            ret = dbUtil.save(member);

            dbUtil.transCommit();
        } catch (Exception e) {
            try {
                dbUtil.transRollBack();
            } catch (Exception ex) {
                logger.error(ex);
            }
            logger.error(e);
        }

        return ret;
    }

    public int update(Member member) {
        int ret = -1;

        try {
            dbUtil.transBegin();
            ret = dbUtil.update(member);

            dbUtil.transCommit();
        } catch (Exception e) {
            try {
                dbUtil.transRollBack();
            } catch (Exception ex) {
                logger.error(ex);
            }
            logger.error(e);
            e.printStackTrace();
        }

        return ret;
    }

    public List<Member> allMembers() {
        try {
            String sql = "select * from member";
            return dbUtil.queryDataTable(sql).toBeanList(Member.class);
        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    public Member queryOneById(String id) {
        try {
            String sql    = "select * from member where id = " + id;
            Member member = dbUtil.queryBean(sql, Member.class);

            return member;
        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    public List<Member> query() {
        return null;
    }
}
