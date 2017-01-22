package com.wcms.service;

import com.wcms.dao.SupplierDao;
import com.wcms.entity.SupplierEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/22.
 */
public class SupplierCrudService {
    private SupplierDao supplierDao;

    private String genNo() {
        List<SupplierEntity> all = supplierDao.findAll();
        Set<String> set = new HashSet<>();
        for (SupplierEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("GYS%04d", i);
            if (!set.contains(no)) {
                return no;
            }
        }

    }

    public void add(SupplierEntity entity) throws ServiceException {
        if (entity.getNo() == null || entity.getNo().equals("")) {
            entity.setNo(genNo());
        } else {
            SupplierEntity byNo = supplierDao.findByNo(entity.getNo());
            if (byNo != null) {
                throw new ServiceException("供应商编号已存在");
            }
        }

        supplierDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        SupplierEntity entity = supplierDao.findById(id);
        if (entity == null) {
            throw new ServiceException("供应商id不存在");
        }
        supplierDao.delete(entity);
    }

    public void update(SupplierEntity entity) throws ServiceException {
        supplierDao.saveOrUpdate(entity);
    }

    public List<SupplierEntity> findAll() {
        return supplierDao.findAll();
    }
    public SupplierDao getSupplierDao() {
        return supplierDao;
    }

    public void setSupplierDao(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }
}
