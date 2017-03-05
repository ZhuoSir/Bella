package com.creheart.platform.bean;

import com.creheart.domain.PlatFunc;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/3/5.
 */
public class PlatMenu {

    private PlatFunc platFunc;

    private List<PlatMenu> childMenus;

    public PlatFunc getPlatFunc() {
        return platFunc;
    }

    public void setPlatFunc(PlatFunc platFunc) {
        this.platFunc = platFunc;
    }

    public List<PlatMenu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<PlatMenu> childMenus) {
        this.childMenus = childMenus;
    }
}
