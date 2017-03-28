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

    public PlatAdmin queryAdminByName(final String name)
            throws Exception {
        String sql = "select * from plat_admin where adminName = ?";
        return dbUtil.queryBean(sql, PlatAdmin.class, name);
    }


    public String queryPwdofAdmin(final String adminName)
            throws Exception {
        String sql = "select password from plat_admin where adminName = ?";
        return dbUtil.querySingleOne(sql, adminName).toString();
    }
}
