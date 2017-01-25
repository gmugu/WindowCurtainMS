package com.wcms.dao;

import com.wcms.entity.OrderlEntity;
import org.hibernate.Query;

/**
 * Created by Administrator on 2017/1/20.
 */
public class OrderDao extends BaseDao<OrderlEntity> {
    public OrderlEntity findByNo(String no) {
        Query query = getSession().createQuery("from OrderlEntity where no=?");
        query.setString(0, no);
        return (OrderlEntity) query.uniqueResult();
    }
}
