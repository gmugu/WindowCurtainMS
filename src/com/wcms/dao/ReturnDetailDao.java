package com.wcms.dao;

import com.wcms.entity.ReturnDetailEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/1/20.
 */
public class ReturnDetailDao extends BaseDao<ReturnDetailEntity> {

    public List<ReturnDetailEntity> findByReturnId(int id) {
        Query query = getSession().createQuery("from ReturnDetailEntity where returnl.id=?");
        query.setInteger(0, id);
        return query.list();
    }
}
