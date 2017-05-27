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

    private final String allNavi = " select * from web_navigation ";

    public List<WebNavigation> getNavigationsInStatus(int status) throws Exception {
        StringBuilder sql = new StringBuilder(allNavi);
        sql.append(" where status = ");
        sql.append(status);

        return queryList(sql.toString(), WebNavigation.class);
    }
}
