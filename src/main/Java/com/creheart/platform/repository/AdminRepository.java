package com.creheart.platform.repository;

import com.chen.JeneralDB.DataTable;
import com.chen.JeneralDB.jdbc.Query;
import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.PlatAdmin;
import org.springframework.stereotype.Component;

/**
 *
 * Created by sunny-chen on 2017/3/12.
 */
@Component
public class AdminRepository extends AbstractRepository<PlatAdmin> {

    public PlatAdmin queryAdminByName(String name)
            throws Exception {
        String sql = "select * from plat_admin where adminName = '" + name + "'";
        return dbUtil.queryBean(sql, PlatAdmin.class);
    }


    public String queryPwdofAdmin(String adminName)
            throws Exception {
        Query query = new Query();
        query.setTableName("plat_admin");
        String[] field = {"password"};
        query.setFields(field);
        query.equal("adminName", adminName);

        return dbUtil.querySingleOne(query).toString();
    }
}
