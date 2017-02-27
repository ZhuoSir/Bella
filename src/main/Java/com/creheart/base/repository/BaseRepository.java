package com.creheart.base.repository;

import com.chen.JeneralDB.DBUtil;
import org.apache.log4j.Logger;

import java.util.List;

/**
 *
 * Created by sunny-chen on 17/2/27.
 */
public abstract class BaseRepository<T> {

    private DBUtil dbUtil = null;

    private Logger logger = Logger.getLogger(BaseRepository.class);

    public int save(T t) {
        return save(null, t, -1);
    }

    public int save(String tableName, T t) {
        return save(tableName, t, -1);
    }

    public int save(T t, int isolationLevel) {
        return save(null, t, isolationLevel);
    }

    public int save(String tableName, T t, int isolationLevel) {
        dbUtil = DBUtil.getInstance();

        int ret = -1;
        try {
            if (isolationLevel >= 0) {
                dbUtil.transBegin(isolationLevel);
            } else {
                dbUtil.transBegin();
            }

            ret = dbUtil.save(t, tableName);

            dbUtil.transCommit();
        } catch (Exception e) {
            logger.error(e);
            try {
                dbUtil.transRollBack();
            } catch (Exception e1) {
                e1.printStackTrace();
                logger.error(e1);
            }
        }

        return ret;
    }

    public int update(T t) {
       return update(null, t);
    }

    public int update(String tableName, T t) {
        dbUtil = DBUtil.getInstance();

        int ret = -1;
        try {
            dbUtil.transBegin();

            ret = dbUtil.update(t, tableName);

            dbUtil.transCommit();
        } catch (Exception e) {
            logger.error(e);
            try {
                dbUtil.transRollBack();
            } catch (Exception e1) {
                e1.printStackTrace();
                logger.error(e1);
            }
        }

        return ret;
    }

    public int delete(T t) {
        return delete(null, t);
    }

    public int delete(String tableName, T t) {
        dbUtil = DBUtil.getInstance();

        int ret = -1;
        try {
            dbUtil.transBegin();

            ret = dbUtil.delete(t, tableName);

            dbUtil.transCommit();
        } catch (Exception e) {
            logger.error(e);
            try {
                dbUtil.transRollBack();
            } catch (Exception e1) {
                e1.printStackTrace();
                logger.error(e1);
            }
        }

        return ret;
    }

    public List<T> queryBySql(String sql, Class<T> t)
            throws Exception {
        return DBUtil.getInstance().queryBeanList(sql, t);
    }

    public <A> List<A> querysBySql(String sql, Class<A> a)
            throws Exception {
        return DBUtil.getInstance().queryBeanList(sql, a);
    }

    public T queryBean(String sql, Class<T> t)
            throws Exception {
        return DBUtil.getInstance().queryBean(sql, t);
    }
}
