package com.wcms.service;

import com.wcms.dao.AfterSalesServiceDao;
import com.wcms.dao.BaseDao;

/**
 * Created by Administrator on 2017/1/19.
 */
public class Server {
    private BaseDao baseDao;

    public String test(){
        return baseDao.test();
    }

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
