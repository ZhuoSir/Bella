package com.creheart.platform.service;

import com.chen.JeneralDB.jdbc.Query;
import com.chen.StringUtil;
import com.creheart.domain.PlatFunc;
import com.creheart.platform.bean.PlatMenu;
import com.creheart.platform.repository.PlatRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by sunny on 2017/2/26.
 */
@Component
public class PlatformService {

    private Logger logger = Logger.getLogger(PlatformService.class);

    @Autowired
    private PlatRepository platRepository;

    public List<PlatMenu> menuList() {
        PlatMenu root     = new PlatMenu();
        PlatFunc platFunc = new PlatFunc();

        platFunc.setFuncid(0);
        root.setPlatFunc(platFunc);
        List<PlatMenu> menus = null;

        try {
            menus = getMenuList(root);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

        return menus;
    }

    private List<PlatMenu> getMenuList(PlatMenu root)
            throws Exception {
        List<PlatFunc> platFuncs = null;
        List<PlatMenu> platMenus = new ArrayList<>();

        StringBuilder sqlBuilder = new StringBuilder(" select * from plat_func ");
        if (null != root) {
            sqlBuilder.append(" where parentFuncID = ");
            sqlBuilder.append(root.getPlatFunc().getFuncid());
            sqlBuilder.append(" and status = 1 ");
            sqlBuilder.append(" order by orderNum; ");
        }

        platFuncs = platRepository.queryBeanList(sqlBuilder.toString(), PlatFunc.class);
        if (null == platFuncs) {
            return null;
        }

        for (PlatFunc func : platFuncs) {
            PlatMenu singleMenu = new PlatMenu();
            singleMenu.setPlatFunc(func);
            platMenus.add(singleMenu);
        }

        for (PlatMenu menu : platMenus) {
            menu.setChildMenus(getMenuList(menu));
        }

        return platMenus;
    }

    public List<PlatFunc> allPlatFunces() {
        List<PlatFunc> ret = null;

        try {
            ret = platRepository.allPlatFuncs();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }

        return ret;
    }

    public int addPlatFunc(PlatFunc platFunc) {
        try {
            return platRepository.save("plat_func", platFunc);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }

        return 0;
    }

    public List<PlatFunc> queryPlatFunces(String funcName, String parentFuncID, String status)
            throws Exception {
        Query query = new Query();
        query.setTableName("plat_func");
        query.equal("status", status);

        if (StringUtil.isNotNullOrEmpty(funcName)) {
            query.like("funcName", funcName);
        }

        if (StringUtil.isNotNullOrEmpty(parentFuncID)) {
            query.equal("parentFuncID", parentFuncID);
        }

        return platRepository.queryByQuery(query);
    }

    /**
     * 获取父节点ID
     * */
    public List<PlatFunc> allParentID() throws Exception {
        return platRepository.getAllParentFuncID();
    }

    public int updatePlat(PlatFunc platFunc) {
        try {
            return platRepository.update("plat_func", platFunc);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return -1;
    }

    public PlatFunc queryOneById(String funcID) throws Exception {
        String sql = "select * from plat_func where funcid = " + funcID;
        return platRepository.queryBean(sql, PlatFunc.class);
    }
}
