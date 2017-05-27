package com.creheart.platform.Const;

/**
 * Created by sunny on 2017/3/26.
 */
public interface Constance {

    /** 帖子正常状态*/
    int PostStatusNormal  = 0;

    /** 帖子隐藏状态*/
    int PostStatusHidden  = -1;

    /** 帖子删除状态*/
    int PostStatusDel     = -9;

    /** 帖子禁止回复*/
    int PostStatusNoReply = -8;

    /** 回复正常状态*/
    int ReplyStatusNormal = 0;

    /** 回复删除状态*/
    int ReplyStatusDel    = -9;

    /** 导航显示状态*/
    int NaviStatusShow    = 0;

    /** 导航隐藏状态*/
    int NaviStatusHidden  = -1;

    /** 导航删除状态*/
    int NaviStatusDelete  = -9;
}
