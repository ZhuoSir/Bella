package com.creheart.platform.repository;

import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.WebNavigation;
import com.creheart.platform.Const.Constance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/5/27.
 */
@Component
public class WebNaviRepository extends AbstractRepository<WebNavigation> {

    private final String tableName = "web_navigation";

    private final String queryNaviAll = " select * from web_navigation ";

    @Override
    public int save(WebNavigation navigation) throws Exception {
        return super.save(tableName, navigation);
    }

    @Override
    public int update(WebNavigation navigation) throws Exception {
        return super.update(tableName, navigation);
    }

    public List<WebNavigation> getNavigationsInStatus(int status) throws Exception {
        String sql = queryNaviAll + " where status = " + status;
        return queryList(sql, WebNavigation.class);
    }

    public int delete(final int id) throws Exception {
        return updateStatus(id, Constance.PostStatusDel);
    }

    public int updateStatus(final int id, final int status) throws Exception {
        String sql = "update web_navigation wn set wn.status = ? where id  = ?;";
        return execute(sql, status, id);
    }

    public WebNavigation getNavigation(final String title) throws Exception {
        String sql = queryNaviAll + " where title = ?;";
        return query(sql, WebNavigation.class);
    }
}
