package com.creheart.base.repository;

import com.chen.JeneralDB.DBUtil;
import com.chen.JeneralDB.DataTable;
import com.chen.JeneralDB.jdbc.Query;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by sunny-chen on 17/2/27.
 */
public abstract class AbstractRepository<T> {

    private DBUtil dbUtil = null;

    public void setDbUtil(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public DBUtil getDbUtil() {
        return dbUtil;
    }

    public int execute(String sql) throws Exception {
        return dbUtil.execute(sql);
    }

    public int execute(String sql, Object... params) throws Exception {
        return dbUtil.execute(sql, params);
    }

    public int[] executeBatch(String... sqls) throws Exception {
        return dbUtil.executeAsBatch(Arrays.asList(sqls));
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

    public T query(String sql, Class<T> tClass) throws Exception {
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

    public Object querySingleOne(String sql) throws Exception {
        return dbUtil.querySingleOne(sql);
    }

    public Object querySingleOne(String sql, Object... params) throws Exception {
        return dbUtil.querySingleOne(sql, params);
    }

    public T queryByQuery(Query query, Class<T> tClass) throws Exception {
        List<T> list = queryListByQuery(query, tClass);
        return null != list ? list.get(0) : null;
    }

    public List<T> queryListByQuery(Query query, Class<T> tClass) throws Exception {
        DataTable dt = dbUtil.queryByQuery(query);
        return null != dt ? dt.toBeanList(tClass) : null;
    }
}
