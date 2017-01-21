package com.wcms.dao;

import com.wcms.entity.CustomerEntity;
import org.hibernate.Query;

/**
 * Created by Administrator on 2017/1/20.
 */
public class CustomerDao extends BaseDao<CustomerEntity> {

    public CustomerEntity findByNo(String no) {
        Query query = getSession().createQuery("from CustomerEntity where no=?");
        query.setString(0, no);
        return (CustomerEntity) query.uniqueResult();
    }
}
