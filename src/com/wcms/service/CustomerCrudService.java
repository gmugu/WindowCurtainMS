package com.wcms.service;

import com.wcms.dao.CustomerDao;
import com.wcms.entity.CustomerEntity;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/21.
 */
public class CustomerCrudService {
    private CustomerDao customerDao;

    public void add(CustomerEntity entity) throws ServiceException {
        CustomerEntity byNo = customerDao.findByNo(entity.getNo());
        if (byNo != null) {
            throw new ServiceException("客户编号已存在");
        }
        customerDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        CustomerEntity entity = customerDao.findById(id);
        if (entity == null) {
            throw new ServiceException("客户id不存在");
        }
        customerDao.delete(entity);
    }

    public void update(CustomerEntity entity) throws ServiceException {
        CustomerEntity byNo = customerDao.findByNo(entity.getNo());
        if (byNo != null) {
            throw new ServiceException("客户编号已存在");
        }
        customerDao.saveOrUpdate(entity);
    }

    public List<CustomerEntity> findAll() {
        return customerDao.findAll();
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
