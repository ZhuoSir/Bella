package com.creheart.platform.bean;

/**
 *
 * Created by sunny-chen on 2017/3/12.
 */
public class Msg {

    /**
     * type: {
     *      1 : 成功
     *     -1 : 错误
     *     -2 : 警告
     * }
     * */
    public int type;

    /**
     * 结果真假判断
     *
     * */
    public boolean result;

    /**
     * 前端给后端消息
     *
     * */
    public String message;

    /**
     * 错误信息
     *
     * */
    public String error;

}