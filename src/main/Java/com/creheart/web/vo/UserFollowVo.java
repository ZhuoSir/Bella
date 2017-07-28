package com.creheart.web.vo;

/**
 *
 * Created by sunny-chen on 2017/7/27.
 */
public class UserFollowVo {

    // 关注标签数量
    private long followLabelCount;

    // 关注用户数量
    private long followUserCount;

    // 收藏帖子
    private long storePostCount;

    public long getFollowLabelCount() {
        return followLabelCount;
    }

    public void setFollowLabelCount(long followLabelCount) {
        this.followLabelCount = followLabelCount;
    }

    public long getFollowUserCount() {
        return followUserCount;
    }

    public void setFollowUserCount(long followUserCount) {
        this.followUserCount = followUserCount;
    }

    public long getStorePostCount() {
        return storePostCount;
    }

    public void setStorePostCount(long storePostCount) {
        this.storePostCount = storePostCount;
    }
}
