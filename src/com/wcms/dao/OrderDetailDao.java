package com.wcms.dao;

import com.wcms.entity.OrderDetailEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/1/20.
 */
public class OrderDetailDao extends BaseDao<OrderDetailEntity> {

    public List<OrderDetailEntity> findByOrderId(int id) {
        Query query = getSession().createQuery("from OrderDetailEntity where order.id=?");
        query.setInteger(0, id);
        return query.list();
    }
}
