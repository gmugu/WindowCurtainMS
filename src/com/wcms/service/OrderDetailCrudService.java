package com.wcms.service;

import com.wcms.dao.CurtainDao;
import com.wcms.dao.OrderDao;
import com.wcms.dao.OrderDetailDao;
import com.wcms.entity.OrderDetailEntity;
import com.wcms.service.exception.ServiceException;

import java.util.List;


/**
 * Created by Administrator on 2017/1/23.
 */
public class OrderDetailCrudService {
    private OrderDetailDao orderDetailDao;
    private OrderDao orderDao;
    private CurtainDao curtainDao;

    public void add(OrderDetailEntity entity) throws ServiceException {
        entity.setOrder(orderDao.findById(entity.getOrder().getId()));
        entity.setCurtain(curtainDao.findByNo(entity.getCurtain().getNo()));
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
        OrderDetailEntity byId = orderDetailDao.findById(entity.getId());
        byId.setCurtain(curtainDao.findByNo(entity.getCurtain().getNo()));
        byId.setLocation(entity.getLocation());
        byId.setHeight(entity.getHeight());
        byId.setCount(entity.getCount());
        byId.setComments(entity.getComments());
        orderDetailDao.saveOrUpdate(byId);
    }

    public List<OrderDetailEntity> findByOrderId(int id) {
        return orderDetailDao.findByOrderId(id);
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

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public CurtainDao getCurtainDao() {
        return curtainDao;
    }

    public void setCurtainDao(CurtainDao curtainDao) {
        this.curtainDao = curtainDao;
    }
}
