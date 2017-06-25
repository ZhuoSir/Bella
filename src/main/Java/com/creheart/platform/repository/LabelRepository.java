package com.creheart.platform.repository;

import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.BelLabel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/5/30.
 */
@Repository
public class LabelRepository extends AbstractRepository<BelLabel> {

    private final String labelTable = "bel_label";

    private final String queryLabelSql = " select bl.* from bel_label bl ";

    public List<BelLabel> getAllLabels() throws Exception {
        return queryList(queryLabelSql, BelLabel.class);
    }

    public BelLabel queryLabelById(int id) throws Exception {
        String sql = queryLabelSql + "  where bl.id = ? ; ";
        return query(sql, BelLabel.class, id);
    }

    public BelLabel queryLabelByLabelName(String labelName) throws Exception {
        String sql = queryLabelSql + " where bl.labelName = ?;";
        return query(sql, BelLabel.class, labelName);
    }

    public List<BelLabel> getLabelsOfLinksCountBeyondNumber(int number) throws Exception {
        String sql = queryLabelSql + "  where bl.linkCount > ?;";
        return queryList(sql, BelLabel.class, number);
    }

    public int[] deletBellabel(int id) throws Exception {
        String sql1 = " delete from post_relate_label where labelID = " + id + ";";
        String sql2 = " delete from " + labelTable + " where id = " + id + ";";

        return executeBatch(sql1, sql2);
    }
}
