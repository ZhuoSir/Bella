package com.creheart.web.service;

import com.creheart.domain.WebNavigation;
import com.creheart.platform.Const.Constance;
import com.creheart.platform.repository.WebNaviRepository;
import com.creheart.web.vo.UserFollowVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/7/27.
 */
@Service
public class IndexService {

    private Logger log = Logger.getLogger(IndexService.class);

    @Autowired
    private WebNaviRepository webNaviRepository;

    /**
     * 获取所有显示状态的导航
     *
     * */
    public List<WebNavigation> webNaviListOnShow() {
        List<WebNavigation> ret = null;
        try {
            ret = webNaviRepository.getNavigationsInStatus(Constance.NaviStatusShow);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
            log.info("获取显示导航出现异常");
        }

        return ret;
    }

    public UserFollowVo userFollowVoInMain() {
        UserFollowVo vo = new UserFollowVo();
        vo.setFollowLabelCount(0);
        vo.setFollowUserCount(0);
        vo.setStorePostCount(0);

        return vo;
    }
}
