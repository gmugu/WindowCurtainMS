package com.wcms.service;

import com.wcms.dao.BusinessDao;
import com.wcms.entity.BusinessEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/23.
 */
public class BusinessCrudService {
    private BusinessDao businessDao;
    private String genNo() {
        List<BusinessEntity> all = businessDao.findAll();
        Set<String> set = new HashSet<>();
        for (BusinessEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("CL%03d", i);
            if (!set.contains(no)) {
                return no;
            }
        }

    }

    public void add(BusinessEntity entity) throws ServiceException {
        if (entity.getNo() == null || entity.getNo().equals("")) {
            entity.setNo(genNo());
        } else {
            BusinessEntity byNo = businessDao.findByNo(entity.getNo());
            if (byNo != null) {
                throw new ServiceException("编号已存在");
            }
        }

        businessDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        BusinessEntity entity = businessDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        businessDao.delete(entity);
    }

    public void update(BusinessEntity entity) throws ServiceException {
        businessDao.saveOrUpdate(entity);
    }

    public List<BusinessEntity> findAll() {
        return businessDao.findAll();
    }


    public BusinessDao getBusinessDao() {
        return businessDao;
    }

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }
}
