package com.wcms.service;

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
    private String genNo() {
        List<OrderlEntity> all = orderDao.findAll();
        Set<String> set = new HashSet<>();
        for (OrderlEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("CL%03d", i);
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
        orderDao.saveOrUpdate(entity);
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
}
