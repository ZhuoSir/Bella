package com.creheart.platform.repository;

import com.chen.StringUtil;
import com.creheart.base.repository.AbstractRepository;
import com.creheart.domain.WebInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/5/27.
 */
@Component
public class WebInfoRepository extends AbstractRepository<WebInfo> {

    private final String getWebInfo = " select * from web_info ";

    public WebInfo getCurrentWebInfo() throws Exception {
        return getWebInfoByVersion(null);
    }

    public WebInfo getWebInfoByVersion(String version) throws Exception {

        StringBuilder sql = new StringBuilder(getWebInfo);

        if (StringUtil.isNullOrEmpty(version)) {
            sql.append(" where status  = 1 order by id desc limit 1 ");
        } else {
            sql.append(" where version = ? order by id desc limit 1 ");
        }

        return query(sql.toString(), WebInfo.class, version);
    }
}
