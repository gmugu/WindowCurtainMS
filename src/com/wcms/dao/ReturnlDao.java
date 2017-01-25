package com.wcms.dao;

import com.wcms.entity.ReturnDetailEntity;
import com.wcms.entity.ReturnlEntity;
import org.hibernate.Query;

/**
 * Created by Administrator on 2017/1/20.
 */
public class ReturnlDao extends BaseDao<ReturnlEntity> {
    public ReturnlEntity findByNo(String no) {
        Query query = getSession().createQuery("from ReturnlEntity where no=?");
        query.setString(0, no);
        return (ReturnlEntity) query.uniqueResult();
    }
}
