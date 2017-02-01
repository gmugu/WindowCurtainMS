package com.wcms.service;

import com.wcms.dao.UsersDao;
import com.wcms.entity.UsersEntity;
import com.wcms.service.exception.ServiceException;
import com.wcms.util.MD5Util;

import java.util.List;

/**
 * Created by Administrator on 2017/2/1.
 */
public class AdminService {
    private UsersDao usersDao;

    public void add(UsersEntity entity) throws ServiceException {
        if (entity.getUsername() == null || entity.getUsername().length() < 3) {
            throw new ServiceException("用户名长度必须大于等于3");
        }
        UsersEntity byId = usersDao.findById(entity.getUsername());
        if (byId != null) {
            throw new ServiceException("用户名已存在");
        }
        if (entity.getPassword() == null || entity.getPassword().length() < 4) {
            throw new ServiceException("密码长度必须大于等于4");
        }
        entity.setPassword(MD5Util.md5ToHexStr(entity.getPassword()));
        usersDao.save(entity);
    }

    public void delete(String username) throws ServiceException {
        UsersEntity entity = usersDao.findById(username);
        if (entity == null) {
            throw new ServiceException("用户名存在");
        }
        usersDao.delete(entity);
    }

    public void update(UsersEntity entity) throws ServiceException {
        UsersEntity byId = usersDao.findById(entity.getUsername());
        if (byId == null) {
            throw new ServiceException("用户名不存在");
        }
        if (entity.getPassword() == null || entity.getPassword().length() < 4) {
            throw new ServiceException("密码长度必须大于等于4");
        }
        byId.setAuBasic(entity.getAuBasic());
        byId.setAuStore(entity.getAuStore());
        byId.setAuBusiness(entity.getAuBusiness());
        byId.setAuOrder(entity.getAuOrder());
        byId.setAuFinancial(entity.getAuFinancial());
        if (!entity.getPassword().equals("******")) {
            byId.setPassword(MD5Util.md5ToHexStr(entity.getPassword()));
        }
        usersDao.saveOrUpdate(byId);
    }

    public List<UsersEntity> findAll() {
        return usersDao.findAll();
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
}
