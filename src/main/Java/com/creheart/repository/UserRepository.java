package com.creheart.repository;

import com.creheart.JeneralDB.DBUtil;
import com.creheart.JeneralDB.DataTable;
import com.creheart.bean.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * Created by sunny on 2017/2/5.
 */
@Repository("userRepository")
public class UserRepository {

    Logger logger = Logger.getLogger(UserRepository.class);

    DBUtil dbUtil = DBUtil.getInstance();

    public int save(User user) throws Exception {
        int ret = -1;

        try {
            dbUtil.transBegin();
            ret = dbUtil.save(user);

            dbUtil.transCommit();
        } catch (Exception e) {
            dbUtil.transRollBack();
            logger.error(e);
        }

        return ret;
    }

    public DataTable allUser() throws Exception {
        String sql = "select * from user";
        return dbUtil.queryDataTable(sql);
    }
}
