package com.wcms.service;

import com.wcms.dao.ReturnDetailDao;
import com.wcms.entity.ReturnDetailEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/23.
 */
public class ReturnDetailCrudService {
    private ReturnDetailDao returnDetailDao;

    public void add(ReturnDetailEntity entity) throws ServiceException {
        returnDetailDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        ReturnDetailEntity entity = returnDetailDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        returnDetailDao.delete(entity);
    }

    public void update(ReturnDetailEntity entity) throws ServiceException {
        returnDetailDao.saveOrUpdate(entity);
    }

    public List<ReturnDetailEntity> findAll() {
        return returnDetailDao.findAll();
    }



    public ReturnDetailDao getReturnDetailDao() {
        return returnDetailDao;
    }

    public void setReturnDetailDao(ReturnDetailDao returnDetailDao) {
        this.returnDetailDao = returnDetailDao;
    }
}
