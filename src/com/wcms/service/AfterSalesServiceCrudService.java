package com.wcms.service;

import com.wcms.dao.AfterSalesServiceDao;
import com.wcms.dao.CustomerDao;
import com.wcms.dao.EmployeeDao;
import com.wcms.entity.AfterSalesServiceEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/23.
 */
public class AfterSalesServiceCrudService {
    private AfterSalesServiceDao afterSalesServiceDao;
    private CustomerDao customerDao;
    private EmployeeDao employeeDao;

    private String genNo() {
        List<AfterSalesServiceEntity> all = afterSalesServiceDao.findAll();
        Set<String> set = new HashSet<>();
        for (AfterSalesServiceEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("SH%03d", i);
            if (!set.contains(no)) {
                return no;
            }
        }

    }

    public void add(AfterSalesServiceEntity entity) throws ServiceException {
        if (entity.getNo() == null || entity.getNo().equals("")) {
            entity.setNo(genNo());
        } else {
            AfterSalesServiceEntity byNo = afterSalesServiceDao.findByNo(entity.getNo());
            if (byNo != null) {
                throw new ServiceException("编号已存在");
            }
        }
        entity.setCustomer(customerDao.findByNo(entity.getCustomer().getNo()));
        entity.setEmployee(employeeDao.findByNo(entity.getEmployee().getNo()));
        afterSalesServiceDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        AfterSalesServiceEntity entity = afterSalesServiceDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        afterSalesServiceDao.delete(entity);
    }

    public void update(AfterSalesServiceEntity entity) throws ServiceException {
        AfterSalesServiceEntity byId = afterSalesServiceDao.findById(entity.getId());
        byId.setTime(entity.getTime());
        byId.setComments(entity.getComments());
        byId.setCustomer(customerDao.findByNo(entity.getCustomer().getNo()));
        byId.setEmployee(employeeDao.findByNo(entity.getEmployee().getNo()));
        afterSalesServiceDao.saveOrUpdate(byId);
    }

    public List<AfterSalesServiceEntity> findAll() {
        return afterSalesServiceDao.findAll();
    }

    public AfterSalesServiceDao getafterSalesServiceDao() {
        return afterSalesServiceDao;
    }

    public void setAfterSalesServiceDao(AfterSalesServiceDao afterSalesServiceDao) {
        this.afterSalesServiceDao = afterSalesServiceDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
