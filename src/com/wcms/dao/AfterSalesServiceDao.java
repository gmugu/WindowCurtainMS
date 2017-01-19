package com.wcms.dao;

import com.wcms.entity.OrderlEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
public class AfterSalesServiceDao extends BaseDao<AfterSalesServiceDao> {
    @Override
    protected Class getEntityClass() {
        return this.getClass();
    }
    public String test(){
        Query query = getSession().createQuery("from OrderlEntity ");
        List<OrderlEntity> list = query.list();
        System.out.println(list);

        return "test";
    }
}
