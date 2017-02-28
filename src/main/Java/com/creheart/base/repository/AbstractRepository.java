package com.creheart.base.repository;

import com.chen.JeneralDB.DBUtil;
import org.apache.log4j.Logger;

import java.util.List;

/**
 *
 * Created by sunny-chen on 17/2/27.
 */
public abstract class AbstractRepository<T> {

    public DBUtil dbUtil = null;

    public void setDbUtil(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public DBUtil getDbUtil() {
        return dbUtil;
    }

    public int save(T t) throws Exception {
        return save(null, t);
    }

    public int save(String tableName, T t) throws Exception {
        dbUtil.transBegin();

        int ret = dbUtil.save(t, tableName);
        dbUtil.transCommit();

        return ret;
    }

    public int update(T t) throws Exception {
       return update(null, t);
    }

    public int update(String tableName, T t) throws Exception {
        dbUtil.transBegin();

        int ret = dbUtil.update(t, tableName);
        dbUtil.transCommit();

        return ret;
    }

    public int delete(T t) throws Exception {
        return delete(null, t);
    }

    public int delete(String tableName, T t) throws Exception {
        dbUtil.transBegin();

        int ret = dbUtil.delete(t, tableName);
        dbUtil.transCommit();

        return ret;
    }

    public T queryBean(String sql, Class<T> t)
            throws Exception {
        return DBUtil.getInstance().queryBean(sql, t);
    }

    public List<T> queryBySql(String sql, Class<T> tClass)
            throws Exception {
        return DBUtil.getInstance().queryBeanList(sql, tClass);
    }
}
