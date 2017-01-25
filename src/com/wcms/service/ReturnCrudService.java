package com.wcms.service;

import com.wcms.dao.ReturnlDao;
import com.wcms.entity.ReturnlEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/23.
 */
public class ReturnCrudService {
    private ReturnlDao returnlDao;
    private String genNo() {
        List<ReturnlEntity> all = returnlDao.findAll();
        Set<String> set = new HashSet<>();
        for (ReturnlEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("CL%03d", i);
            if (!set.contains(no)) {
                return no;
            }
        }

    }

    public void add(ReturnlEntity entity) throws ServiceException {
        if (entity.getNo() == null || entity.getNo().equals("")) {
            entity.setNo(genNo());
        } else {
            ReturnlEntity byNo = returnlDao.findByNo(entity.getNo());
            if (byNo != null) {
                throw new ServiceException("编号已存在");
            }
        }

        returnlDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        ReturnlEntity entity = returnlDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        returnlDao.delete(entity);
    }

    public void update(ReturnlEntity entity) throws ServiceException {
        returnlDao.saveOrUpdate(entity);
    }

    public List<ReturnlEntity> findAll() {
        return returnlDao.findAll();
    }



    public ReturnlDao getReturnlDao() {
        return returnlDao;
    }

    public void setReturnlDao(ReturnlDao returnlDao) {
        this.returnlDao = returnlDao;
    }
}
