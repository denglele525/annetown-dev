package com.annetown.service.impl.center;

import com.annetown.mapper.ShopUserMapper;
import com.annetown.pojo.ShopUser;
import com.annetown.pojo.bo.center.CenterUserBO;
import com.annetown.service.center.CenterUserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CenterUserServiceImpl implements CenterUserService {

    @Autowired
    public ShopUserMapper ShopUserMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ShopUser queryUserInfo(String userId) {
        ShopUser user = ShopUserMapper.selectByPrimaryKey(userId);
        user.setPassword(null);
        return user;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ShopUser updateUserInfo(String userId, CenterUserBO centerUserBO) {

        ShopUser updateUser = new ShopUser();
        BeanUtils.copyProperties(centerUserBO, updateUser);
        updateUser.setId(userId);
        updateUser.setUpdatedTime(new Date());

        ShopUserMapper.updateByPrimaryKeySelective(updateUser);

        return queryUserInfo(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ShopUser updateUserFace(String userId, String faceUrl) {
        ShopUser updateUser = new ShopUser();
        updateUser.setId(userId);
        updateUser.setFace(faceUrl);
        updateUser.setUpdatedTime(new Date());

        ShopUserMapper.updateByPrimaryKeySelective(updateUser);

        return queryUserInfo(userId);
    }
}
