package com.creheart.platform.repository;

import com.chen.JeneralDB.jdbc.Query;
import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.PlatFunc;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny on 2017/2/26.
 */
@Component
public class PlatRepository extends AbstractRepository<PlatFunc> {

    public List<PlatFunc> allPlatFuncs() throws Exception {
        String sql = "select * from plat_func order by funcid;";
        return getDbUtil().queryBeanList(sql, PlatFunc.class);
    }

    public List<PlatFunc> queryByQuery(final Query query)
            throws Exception {
        return getDbUtil().queryBeanListByQuery(query, PlatFunc.class);
    }

    public List<PlatFunc> getAllParentFuncID()
            throws Exception {
        String sql = "select funcid , funcName from plat_func;";
        return getDbUtil().queryBeanList(sql, PlatFunc.class);
    }
}
