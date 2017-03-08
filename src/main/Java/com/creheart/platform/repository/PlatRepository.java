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

    public List<PlatFunc> queryByQuery(Query query)
            throws Exception {
        return dbUtil.queryByQuery(query, PlatFunc.class);
    }
}
