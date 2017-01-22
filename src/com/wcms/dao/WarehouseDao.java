package com.wcms.dao;

import com.wcms.entity.WarehouseEntity;
import org.hibernate.Query;

/**
 * Created by Administrator on 2017/1/20.
 */
public class WarehouseDao extends BaseDao<WarehouseEntity> {
    public WarehouseEntity findByNo(String no) {
        Query query = getSession().createQuery("from WarehouseEntity where no=?");
        query.setString(0, no);
        return (WarehouseEntity) query.uniqueResult();
    }
}
