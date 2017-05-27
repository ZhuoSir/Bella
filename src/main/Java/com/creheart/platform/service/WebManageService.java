package com.creheart.platform.service;

import com.creheart.domain.WebInfo;
import com.creheart.domain.WebNavigation;
import com.creheart.platform.Const.Constance;
import com.creheart.platform.repository.WebInfoRepository;
import com.creheart.platform.repository.WebNaviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 * Created by sunny-chen on 2017/5/27.
 */
@Component
public class WebManageService {

    @Autowired
    private PlatformService platformService;

    @Autowired
    private WebInfoRepository webInfoRepository;

    @Autowired
    private WebNaviRepository webNaviRepository;

    public WebInfo currentWebInfo() throws Exception {
        return webInfoRepository.getCurrentWebInfo();
    }

    public WebInfo webInfoOfVersion(String version) throws Exception {
        return webInfoRepository.getWebInfoByVersion(version);
    }

    public List<WebNavigation> allNavigationInShow() throws Exception {
        return webNaviRepository.getNavigationsInStatus(Constance.NaviStatusShow);
    }

    public List<WebNavigation> allNavigationInHidden() throws Exception {
        return webNaviRepository.getNavigationsInStatus(Constance.NaviStatusHidden);
    }

    public List<WebNavigation> allNavigationInDelete() throws Exception {
        return webNaviRepository.getNavigationsInStatus(Constance.NaviStatusDelete);
    }
}
