package com.creheart.platform.repository;

import com.chen.JeneralDB.DBUtil;
import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.PlatFunc;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny on 2017/2/26.
 */
@Component
public class PlatRepository extends AbstractRepository<PlatFunc> {

    public List<PlatFunc> allPlatFunces() throws Exception {
        String sql = "select * from plat_func";
        List<PlatFunc> ret = queryBeanList(sql, PlatFunc.class);
        System.out.println(ret);
        return ret;
    }
}
