package com.creheart.platform.repository;

import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.WebNavigation;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/5/27.
 */
@Component
public class WebNaviRepository extends AbstractRepository<WebNavigation> {

    private final String queryNaviAll = " select * from web_navigation ";

    private final String deleteNavi   = " delete from web_navigation ";

    public List<WebNavigation> getNavigationsInStatus(int status) throws Exception {
        StringBuilder sql = new StringBuilder(queryNaviAll);
        sql.append(" where status = ");
        sql.append(status);

        return queryList(sql.toString(), WebNavigation.class);
    }

    public int delete(int id) throws Exception {
        StringBuilder sql = new StringBuilder(deleteNavi);
        sql.append(" where id = ?");

        return execute(sql.toString(), id);
    }
}
