package com.wcms.service;

import com.wcms.dao.BusinessDao;
import com.wcms.dao.CustomerDao;
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
    private CustomerDao customerDao;

    private String genNo() {
        List<BusinessEntity> all = businessDao.findAll();
        Set<String> set = new HashSet<>();
        for (BusinessEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("YW%03d", i);
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
        entity.setState("预约");
        entity.setCustomer(customerDao.findByNo(entity.getCustomer().getNo()));
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
        BusinessEntity byId = businessDao.findById(entity.getId());
        byId.setSignTime(entity.getSignTime());
        byId.setBusinessType(entity.getBusinessType());
        byId.setCustomer(customerDao.findByNo(entity.getCustomer().getNo()));
        byId.setAppointmentTime(entity.getAppointmentTime());
        byId.setComments(entity.getComments());
        entity.setState("预约");
        businessDao.saveOrUpdate(byId);
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

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public BusinessEntity signAdd(BusinessEntity entity) throws ServiceException {
        BusinessEntity byNo = businessDao.findByNo(entity.getNo());
        if (byNo == null) {
            throw new ServiceException("业务号不存在，无法签收");
        }
        if ("已派工".equals(byNo.getState())) {
            throw new ServiceException("业务已派工");
        }
        byNo.setAcceptanceTime(entity.getAcceptanceTime());
        byNo.setCommentsReg(entity.getCommentsReg());
        byNo.setState("已派工");
        businessDao.saveOrUpdate(byNo);
        return byNo;
    }

    public BusinessEntity signUpdate(BusinessEntity entity) {
        BusinessEntity byId = businessDao.findById(entity.getId());
        byId.setAcceptanceTime(entity.getAcceptanceTime());
        byId.setCommentsReg(entity.getCommentsReg());
        businessDao.saveOrUpdate(byId);
        return byId;
    }

    public void signDelete(int id) throws ServiceException {
        BusinessEntity entity = businessDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        entity.setState("预约");
        entity.setAcceptanceTime(null);
        entity.setCommentsReg(null);
    }
}
