package com.wcms.service;

import com.wcms.dao.OrderDetailDao;
import com.wcms.entity.OrderDetailEntity;
import com.wcms.service.exception.ServiceException;

import java.util.List;


/**
 * Created by Administrator on 2017/1/23.
 */
public class OrderDetailCrudService {
    private OrderDetailDao orderDetailDao;


    public void add(OrderDetailEntity entity) throws ServiceException {
        orderDetailDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        OrderDetailEntity entity = orderDetailDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        orderDetailDao.delete(entity);
    }

    public void update(OrderDetailEntity entity) throws ServiceException {
        orderDetailDao.saveOrUpdate(entity);
    }

    public List<OrderDetailEntity> findAll() {
        return orderDetailDao.findAll();
    }



    public OrderDetailDao getOrderDetailDao() {
        return orderDetailDao;
    }

    public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }
}
