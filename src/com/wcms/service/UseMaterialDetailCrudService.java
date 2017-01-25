package com.wcms.service;

import com.wcms.dao.UseMaterialDetailDao;
import com.wcms.entity.UseMaterialDetailEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/23.
 */
public class UseMaterialDetailCrudService {
    private UseMaterialDetailDao useMaterialDetailDao;

    public void add(UseMaterialDetailEntity entity) throws ServiceException {
        useMaterialDetailDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        UseMaterialDetailEntity entity = useMaterialDetailDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        useMaterialDetailDao.delete(entity);
    }

    public void update(UseMaterialDetailEntity entity) throws ServiceException {
        useMaterialDetailDao.saveOrUpdate(entity);
    }

    public List<UseMaterialDetailEntity> findAll() {
        return useMaterialDetailDao.findAll();
    }

    public UseMaterialDetailDao getUseMaterialDetailDao() {
        return useMaterialDetailDao;
    }

    public void setUseMaterialDetailDao(UseMaterialDetailDao useMaterialDetailDao) {
        this.useMaterialDetailDao = useMaterialDetailDao;
    }
}
