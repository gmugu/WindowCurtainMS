package com.wcms.service;

import com.wcms.dao.SalaryDao;
import com.wcms.entity.SalaryEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/23.
 */
public class SalaryCrudService {
    private SalaryDao salaryDao;

    public void add(SalaryEntity entity) throws ServiceException {
        salaryDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        SalaryEntity entity = salaryDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        salaryDao.delete(entity);
    }

    public void update(SalaryEntity entity) throws ServiceException {
        salaryDao.saveOrUpdate(entity);
    }

    public List<SalaryEntity> findAll() {
        return salaryDao.findAll();
    }


    public SalaryDao getSalaryDao() {
        return salaryDao;
    }

    public void setSalaryDao(SalaryDao salaryDao) {
        this.salaryDao = salaryDao;
    }
}
