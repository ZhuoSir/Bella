package com.creheart.platform.repository;

import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.PlatAdmin;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/3/12.
 */
@Component
public class AdminRepository extends AbstractRepository<PlatAdmin> {

    private final String queryAdminSql = " select ID, adminName, adminType, status, creatorID, addTime from plat_admin ";

    public PlatAdmin queryAdminByName(final String name)
            throws Exception {
        StringBuilder sql = new StringBuilder(queryAdminSql);
        sql.append(" where adminName = ?;");

        return getDbUtil().queryBean(sql.toString(), PlatAdmin.class, name);
    }

    public PlatAdmin queryAdminById(final int id) throws Exception {
        StringBuilder sql = new StringBuilder(queryAdminSql);
        sql.append(" where ID = ?;");

        return query(sql.toString(), PlatAdmin.class, id);
    }

    public List<PlatAdmin> querAdminsByName(final String name) throws Exception {
        StringBuilder sql = new StringBuilder(queryAdminSql);
        sql.append(" where adminName like '%");
        sql.append(name);
        sql.append("%';");

        return queryList(sql.toString(), PlatAdmin.class);
    }


    public String queryPwdofAdmin(final String adminName)
            throws Exception {
        String sql = "select password from plat_admin where adminName = ?";
        return getDbUtil().querySingleOne(sql, adminName).toString();
    }
}
