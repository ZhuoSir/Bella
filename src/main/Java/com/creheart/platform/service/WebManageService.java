package com.creheart.platform.service;

import com.chen.DateUtil;
import com.chen.StringUtil;
import com.creheart.domain.WebInfo;
import com.creheart.domain.WebNavigation;
import com.creheart.platform.Const.Constance;
import com.creheart.platform.repository.WebInfoRepository;
import com.creheart.platform.repository.WebNaviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
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

    /**
     * 获取当前web版本信息
     *
     * */
    public WebInfo currentWebInfo() throws Exception {
        return webInfoRepository.getCurrentWebInfo();
    }

    /**
     * 创建新的web版本信息
     *
     * */
    public int createNewWebInfo(WebInfo webInfo) throws Exception {
        if (null == webInfo)
            return -1;

        if (null == webInfo.getStartTime())
            webInfo.setStartTime(new Date(DateUtil.currentTime()));

        if (StringUtil.isNullOrEmpty(webInfo.getVersion()))
            return -1;

        return webInfoRepository.save("web_info", webInfo);
    }

    /**
     * 获取某一版本的wen信息
     *
     * */
    public WebInfo webInfoOfVersion(String version) throws Exception {
        return webInfoRepository.getWebInfoByVersion(version);
    }

    /**
     * 创建新的web前端导航
     *
     * */
    public int createNewNavigation(String title, int manageID, int status) throws Exception {
        WebNavigation navi = new WebNavigation(title, manageID, status);
        navi.setCreateTime(new Date());

        return webNaviRepository.save("web_navigation", navi);
    }

    /**
     * 创建新的web前端导航
     *
     * */
    public int createNewNavigation(WebNavigation navigation) throws Exception {
        if (null == navigation)
            throw new NullPointerException("WebNavigation不能为Null");

        if (null == navigation.getCreateTime())
            navigation.setCreateTime(new Date());

        if (StringUtil.isNullOrEmpty(navigation.getTitle()))
            throw new IllegalArgumentException("WebNavigation的title不能为空");

        return webNaviRepository.save("web_navigation", navigation);
    }

    /**
     * 删除web前端导航
     *
     * @param naviID 导航ID
     *
     * */
    public int deleteNavigation(int naviID) throws Exception {
        return webNaviRepository.delete(naviID);
    }

    /**
     * 显示状态的导航
     *
     * */
    public List<WebNavigation> allNavigationInShow() throws Exception {
        return webNaviRepository.getNavigationsInStatus(Constance.NaviStatusShow);
    }

    /**
     * 隐藏状态的导航
     *
     * */
    public List<WebNavigation> allNavigationInHidden() throws Exception {
        return webNaviRepository.getNavigationsInStatus(Constance.NaviStatusHidden);
    }

    /**
     * 删除状态的导航
     *
     * */
    public List<WebNavigation> allNavigationInDelete() throws Exception {
        return webNaviRepository.getNavigationsInStatus(Constance.NaviStatusDelete);
    }
}
