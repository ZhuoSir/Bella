package com.creheart.platform.repository;

import com.chen.JeneralDB.DBUtil;
import com.chen.JeneralDB.jdbc.Query;
import com.creheart.base.repository.BaseRepository;
import com.creheart.domain.PlatFunc;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny on 2017/2/26.
 */
@Component
public class PlatRepository extends BaseRepository<PlatFunc> {

    private DBUtil dbUtil = null;

    private Logger log = Logger.getLogger(PlatRepository.class);

    public List<PlatFunc> allPlatFunces() {
        dbUtil = DBUtil.getInstance();

        List<PlatFunc> ret = null;
        try {
            String sql = "select * from plat_func";
            ret = dbUtil.queryBeanList(sql, PlatFunc.class);
        } catch (Exception e) {
            log.error(e);
            e.printStackTrace();
        }

        return ret;
    }
}
