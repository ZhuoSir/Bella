package com.creheart.platform.bean.vo;

import com.creheart.domain.BelReply;

/**
 *
 * Created by sunny-chen on 2017/5/29.
 */
public class BelReplyVo extends BelReply {

    private String accountName;

    private String nickName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
