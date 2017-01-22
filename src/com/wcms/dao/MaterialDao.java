package com.wcms.dao;

import com.wcms.entity.CurtainEntity;
import com.wcms.entity.MaterialEntity;
import org.hibernate.Query;

/**
 * Created by Administrator on 2017/1/20.
 */
public class MaterialDao extends BaseDao<MaterialEntity> {
    public MaterialEntity findByNo(String no) {
        Query query = getSession().createQuery("from MaterialEntity where no=?");
        query.setString(0, no);
        return (MaterialEntity) query.uniqueResult();
    }
}
