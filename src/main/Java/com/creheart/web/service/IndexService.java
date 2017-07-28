package com.creheart.web.service;

import com.chen.JeneralDB.DBUtil;
import com.creheart.domain.WebNavigation;
import com.creheart.platform.Const.Constance;
import com.creheart.platform.repository.WebNaviRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * index首页所需业务逻辑
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


    /**
     * 获取用户关注标签数量
     *
     * @param memberID 用户id
     *
     * */
    public Long countOfMemberLinkLabel(Long memberID) {
        DBUtil dbUtil = DBUtil.getInstance();
        String sql = " select count(RID) from member_link_label where memberID = ? ";
        try {
            return (Long) dbUtil.querySingleOne(sql, memberID);
        } catch (Exception e) {
            e.printStackTrace();log.error(e);
            log.info("获取用户：" + memberID + "关注标签数量失败");
            return 0L;
        }
    }


    /**
     * 获取用户关注帖子数量
     *
     * @param memberID 用户id
     *
     * */
    public Long countOfMemberLinkPost(Long memberID) {
        DBUtil dbUtil = DBUtil.getInstance();
        String sql = " select count(id) from member_link_post where memberID = ? ";
        try {
            return (Long) dbUtil.querySingleOne(sql, memberID);
        } catch (Exception e) {
            e.printStackTrace();log.error(e);
            log.info("获取用户：" + memberID + "关注帖子数量失败");
            return 0L;
        }
    }


    /**
     * 获取用户关注用户数量
     *
     * @param memberID 用户id
     *
     * */
    public Long countOfMemberLinkMem(Long memberID) {
        DBUtil dbUtil = DBUtil.getInstance();
        String sql = " select count(id) from member_link_mem where memberID = ? ";
        try {
            return (Long) dbUtil.querySingleOne(sql, memberID);
        } catch (Exception e) {
            e.printStackTrace();log.error(e);
            log.info("获取用户：" + memberID + "关注用户数量失败");
            return 0L;
        }
    }
}
