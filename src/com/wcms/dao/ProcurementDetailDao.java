package com.wcms.dao;

import com.wcms.entity.ProcurementDetailEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/1/20.
 */
public class ProcurementDetailDao extends BaseDao<ProcurementDetailEntity> {

    public List<ProcurementDetailEntity> findByProcurementId(int id) {
        Query query = getSession().createQuery("from ProcurementDetailEntity where procurement.id=?");
        query.setInteger(0, id);
        return query.list();
    }
}
