package com.wcms.service;

import com.wcms.dao.UsersDao;
import com.wcms.entity.UsersEntity;
import com.wcms.service.exception.ServiceException;
import com.wcms.util.MD5Util;

/**
 * Created by Administrator on 2017/2/1.
 */
public class LoginService {
    private UsersDao usersDao;

    public UsersEntity login(String username, String password) throws ServiceException {
        UsersEntity usersEntity = usersDao.findById(username);
        if (usersEntity == null) {
            throw new ServiceException("用户名不存在");
        }
        if (!usersEntity.getPassword().equals(MD5Util.md5ToHexStr(password))) {
            throw new ServiceException("用户名密码错误");
        }
        return usersEntity;
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
}
