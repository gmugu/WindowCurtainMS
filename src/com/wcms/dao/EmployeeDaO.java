package com.wcms.dao;

import com.wcms.entity.EmployeeEntity;
import org.hibernate.Query;

/**
 * Created by Administrator on 2017/1/20.
 */
public class EmployeeDao extends BaseDao<EmployeeEntity>{
    public EmployeeEntity findByNo(String no) {
        Query query = getSession().createQuery("from EmployeeEntity where no=?");
        query.setString(0, no);
        return (EmployeeEntity) query.uniqueResult();
    }
}
