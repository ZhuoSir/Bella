package com.creheart.platform.bean.vo;

import com.creheart.domain.BelPost;

/**
 *
 * Created by sunny on 2017/4/14.
 */
public class BelPostVo extends BelPost {

    private String accountName;

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    private String nickName;

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }
}
