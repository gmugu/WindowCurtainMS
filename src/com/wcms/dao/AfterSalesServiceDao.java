package com.wcms.dao;

import com.wcms.entity.AfterSalesServiceEntity;
import com.wcms.entity.OrderDetailEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
public class AfterSalesServiceDao extends BaseDao<AfterSalesServiceEntity> {

    public AfterSalesServiceEntity findByNo(String no) {
        Query query = getSession().createQuery("from AfterSalesServiceEntity where no=?");
        query.setString(0, no);
        return (AfterSalesServiceEntity) query.uniqueResult();
    }
}
