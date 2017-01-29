
package com.wcms.service;

import com.wcms.dao.CustomerDao;
import com.wcms.dao.OrderDao;
import com.wcms.entity.OrderlEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/23.
 */
public class OrderCrudService {
    private OrderDao orderDao;
    private CustomerDao customerDao;

    private String genNo() {
        List<OrderlEntity> all = orderDao.findAll();
        Set<String> set = new HashSet<>();
        for (OrderlEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("DD%03d", i);
            if (!set.contains(no)) {
                return no;
            }
        }

    }

    public void add(OrderlEntity entity) throws ServiceException {
        if (entity.getNo() == null || entity.getNo().equals("")) {
            entity.setNo(genNo());
        } else {
            OrderlEntity byNo = orderDao.findByNo(entity.getNo());
            if (byNo != null) {
                throw new ServiceException("编号已存在");
            }
        }
        entity.setCustomer(customerDao.findByNo(entity.getCustomer().getNo()));
        entity.setState("预定");
        orderDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        OrderlEntity entity = orderDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        orderDao.delete(entity);
    }

    public void update(OrderlEntity entity) throws ServiceException {
        OrderlEntity byId = orderDao.findById(entity.getId());
        byId.setOrderTime(entity.getOrderTime());
        byId.setCustomer(customerDao.findByNo(entity.getCustomer().getNo()));
        byId.setDeliveryTime(entity.getDeliveryTime());
        byId.setDownpayment(entity.getDownpayment());
        byId.setComments(entity.getComments());
        orderDao.saveOrUpdate(byId);
    }

    public OrderlEntity signAdd(OrderlEntity entity) throws ServiceException {
        OrderlEntity byNo = orderDao.findByNo(entity.getNo());
        if (byNo == null) {
            throw new ServiceException("订单号不存在，无法签收");
        }
        if ("签收".equals(byNo.getState())) {
            throw new ServiceException("订单号已签收");
        }
        byNo.setAcceptanceTime(entity.getAcceptanceTime());
        byNo.setAmountPaid(entity.getAmountPaid());
        byNo.setCommentsSign(entity.getCommentsSign());
        byNo.setState("签收");
        orderDao.saveOrUpdate(byNo);
        return byNo;
    }

    public OrderlEntity signUpdate(OrderlEntity entity) throws ServiceException {
        OrderlEntity byId = orderDao.findById(entity.getId());
        byId.setAcceptanceTime(entity.getAcceptanceTime());
        byId.setAmountPaid(entity.getAmountPaid());
        byId.setCommentsSign(entity.getCommentsSign());
        orderDao.saveOrUpdate(byId);
        return byId;
    }

    public List<OrderlEntity> findAll() {
        return orderDao.findAll();
    }


    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    public void signDelete(int id) throws ServiceException {
        OrderlEntity entity = orderDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        entity.setState("预定");
        entity.setAcceptanceTime(null);
        entity.setAmountPaid(null);
        entity.setCommentsSign(null);
        orderDao.saveOrUpdate(entity);
    }
}
