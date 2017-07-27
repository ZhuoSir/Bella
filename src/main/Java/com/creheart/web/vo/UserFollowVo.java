package com.creheart.web.vo;

/**
 *
 * Created by sunny-chen on 2017/7/27.
 */
public class UserFollowVo {

    // 关注标签数量
    private int followLabelCount;

    // 关注用户数量
    private int followUserCount;

    // 收藏帖子
    private int storePostCount;

    public int getFollowLabelCount() {
        return followLabelCount;
    }

    public void setFollowLabelCount(int followLabelCount) {
        this.followLabelCount = followLabelCount;
    }

    public int getFollowUserCount() {
        return followUserCount;
    }

    public void setFollowUserCount(int followUserCount) {
        this.followUserCount = followUserCount;
    }

    public int getStorePostCount() {
        return storePostCount;
    }

    public void setStorePostCount(int storePostCount) {
        this.storePostCount = storePostCount;
    }
}
