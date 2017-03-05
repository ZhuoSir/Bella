package com.creheart.aop;

import com.chen.JeneralDB.DBUtil;
import com.creheart.base.repository.AbstractRepository;
import org.aspectj.lang.JoinPoint;

/**
 *
 * Created by sunny-chen on 17/2/28.
 */
public class TransactionHandler {

    public void transBegin(JoinPoint joinpoint) {
        ((AbstractRepository) joinpoint.getTarget()).setDbUtil(DBUtil.getInstance());
        try {
            ((AbstractRepository) joinpoint.getTarget()).getDbUtil().transBegin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transRollBack(JoinPoint joinPoint) {
        try {
            ((AbstractRepository) joinPoint.getTarget()).getDbUtil().transRollBack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transCommit(JoinPoint joinPoint) {
        try {
            ((AbstractRepository) joinPoint.getTarget()).getDbUtil().transCommit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
