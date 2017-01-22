package com.wcms.dao;

import com.wcms.entity.MaterialEntity;
import com.wcms.entity.SupplierEntity;
import org.hibernate.Query;

/**
 * Created by Administrator on 2017/1/20.
 */
public class SupplierDao extends BaseDao<SupplierEntity> {
    public SupplierEntity findByNo(String no) {
        Query query = getSession().createQuery("from SupplierEntity where no=?");
        query.setString(0, no);
        return (SupplierEntity) query.uniqueResult();
    }
}
