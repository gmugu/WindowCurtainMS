package com.wcms.dao;

import com.wcms.entity.ProcurementEntity;
import org.hibernate.Query;

/**
 * Created by Administrator on 2017/1/20.
 */
public class ProcurementDao extends BaseDao<ProcurementEntity> {
    public ProcurementEntity findByNo(String no) {
        Query query = getSession().createQuery("from ProcurementEntity where no=?");
        query.setString(0, no);
        return (ProcurementEntity) query.uniqueResult();
    }
}
