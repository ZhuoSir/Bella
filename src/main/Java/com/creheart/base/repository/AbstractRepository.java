package com.creheart.base.repository;

import com.chen.JeneralDB.DBUtil;
import com.chen.JeneralDB.DataTable;
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
        return dbUtil.save(t, tableName);
    }

    public int update(T t) throws Exception {
       return update(null, t);
    }

    public int update(String tableName, T t) throws Exception {
        return dbUtil.update(t, tableName);
    }

    public int delete(T t) throws Exception {
        return delete(null, t);
    }

    public int delete(String tableName, T t) throws Exception {
        return dbUtil.delete(t, tableName);
    }

    public T queryBean(String sql, Class<T> tClass) throws Exception {
        return dbUtil.queryBean(sql, tClass);
    }

    public T query(String sql, Class<T> tClass, Object... params) throws Exception {
        return dbUtil.queryBean(sql, tClass, params);
    }

    public List<T> queryList(String sql, Class<T> tClass) throws Exception {
        return dbUtil.queryBeanList(sql, tClass);
    }

    public List<T> queryList(String sql, Class<T> tClass, Object... params) throws Exception {
        return dbUtil.queryBeanList(sql, tClass, params);
    }

    public DataTable query(String sql) throws Exception {
        return dbUtil.queryDataTable(sql);
    }

    public DataTable query(String sql, Object... params) throws Exception {
        return dbUtil.queryDataTable(sql, params);
    }
}
