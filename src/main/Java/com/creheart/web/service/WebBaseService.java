package com.creheart.web.service;

import com.chen.DateUtil;
import com.chen.JeneralDB.DBUtil;
import com.creheart.domain.WebNavigation;
import com.creheart.platform.Const.Constance;
import com.creheart.platform.bean.vo.BelPostVo;
import com.creheart.platform.repository.WebNaviRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * web基本所需业务逻辑
 *
 * Created by sunny-chen on 2017/7/27.
 */
@Service
public class WebBaseService {

    private Logger log = Logger.getLogger(WebBaseService.class);

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
        String sql = " select count(RID) from member_link_label where memberID = ? ";
        try {
            return (Long) DBUtil.getInstance().querySingleOne(sql, memberID);
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
        String sql = " select count(id) from member_link_post where memberID = ? ";
        try {
            return (Long) DBUtil.getInstance().querySingleOne(sql, memberID);
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
        String sql = " select count(id) from member_link_mem where memberID = ? ";
        try {
            return (Long) DBUtil.getInstance().querySingleOne(sql, memberID);
        } catch (Exception e) {
            e.printStackTrace();log.error(e);
            log.info("获取用户：" + memberID + "关注用户数量失败");
            return 0L;
        }
    }


    /**
     * 首页近期热议：<br>
     * <a>获取一周之内回复数量排行前十的帖子</a>
     *
     * */
    public List<BelPostVo> popularPostsInOneWeek() {
        String sql = " select b.postID, b.title, m.nickName, m.headPicFileUrl " +
                "from bel_post b, member m where b.authorID = m.ID and b.createTime > ? " +
                "order by b.replyTimes; ";

        List<BelPostVo> ret = null;
        try {
            ret = DBUtil.getInstance().queryBeanList(sql, BelPostVo.class, DateUtil.oneWeekAgo());
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
            log.info("获取近期热议失败！");
        }

        return ret;
    }
}
