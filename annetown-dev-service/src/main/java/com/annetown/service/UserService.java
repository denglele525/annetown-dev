package com.annetown.service;

import com.annetown.pojo.ShopUser;
import com.annetown.pojo.bo.UserBO;

public interface UserService {

    /**
     * 判断用户名是否存在
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 判断用户名是否存在
     */
    ShopUser createUser(UserBO userBO);

    /**
     * 检索用户名和密码是否匹配，用于登录
     */
    ShopUser queryUserForLogin(String username, String password);
}
