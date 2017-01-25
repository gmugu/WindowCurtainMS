package com.wcms.dao;

import com.wcms.entity.AfterSalesServiceEntity;
import com.wcms.entity.BusinessEntity;
import org.hibernate.Query;

/**
 * Created by Administrator on 2017/1/20.
 */
public class BusinessDao extends BaseDao<BusinessEntity> {

    public BusinessEntity findByNo(String no) {
        Query query = getSession().createQuery("from BusinessEntity where no=?");
        query.setString(0, no);
        return (BusinessEntity) query.uniqueResult();
    }
}
