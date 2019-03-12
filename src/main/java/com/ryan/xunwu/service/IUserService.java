package com.ryan.xunwu.service;

import com.ryan.xunwu.entity.User;

/**
 * @Description
 *  用户服务
 * @Param
 * @return
 * @Author linzhenhong
 * @Date 2019/3/12 17:08
 */

public interface IUserService {
    User findUserByName(String userName);
}
