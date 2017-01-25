package com.wcms.service;

import com.wcms.dao.MaterialDao;
import com.wcms.dao.ReturnDetailDao;
import com.wcms.dao.ReturnlDao;
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
    private ReturnlDao returnlDao;
    private MaterialDao materialDao;

    public void add(ReturnDetailEntity entity) throws ServiceException {
        entity.setReturnl(returnlDao.findById(entity.getReturnl().getId()));
        entity.setMaterial(materialDao.findByNo(entity.getMaterial().getNo()));
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
        ReturnDetailEntity byId = returnDetailDao.findById(entity.getId());
        byId.setMaterial(materialDao.findByNo(entity.getMaterial().getNo()));
        byId.setCounts(entity.getCounts());
        returnDetailDao.saveOrUpdate(byId);
    }

    public List<ReturnDetailEntity> findAll() {
        return returnDetailDao.findAll();
    }


    public ReturnDetailDao getReturnDetailDao() {
        return returnDetailDao;
    }

    public List<ReturnDetailEntity> findByReturnId(int id) {
        return returnDetailDao.findByReturnId(id);
    }

    public void setReturnDetailDao(ReturnDetailDao returnDetailDao) {
        this.returnDetailDao = returnDetailDao;
    }


    public ReturnlDao getReturnlDao() {
        return returnlDao;
    }

    public void setReturnlDao(ReturnlDao returnlDao) {
        this.returnlDao = returnlDao;
    }

    public MaterialDao getMaterialDao() {
        return materialDao;
    }

    public void setMaterialDao(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }
}
