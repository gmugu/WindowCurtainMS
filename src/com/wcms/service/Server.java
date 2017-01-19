package com.wcms.service;

import com.wcms.dao.AfterSalesServiceDao;

/**
 * Created by Administrator on 2017/1/19.
 */
public class Server {
    private AfterSalesServiceDao baseDao;

    public String test(){
        return baseDao.test();
    }

    public AfterSalesServiceDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(AfterSalesServiceDao baseDao) {
        this.baseDao = baseDao;
    }
}
