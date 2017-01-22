package com.wcms.dao;

import com.wcms.entity.CurtainEntity;
import org.hibernate.Query;

/**
 * Created by Administrator on 2017/1/20.
 */
public class CurtainDao extends BaseDao<CurtainEntity> {
    public CurtainEntity findByNo(String no) {
        Query query = getSession().createQuery("from CurtainEntity where no=?");
        query.setString(0, no);
        return (CurtainEntity) query.uniqueResult();
    }
}
