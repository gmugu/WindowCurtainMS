package com.wcms.service;

import com.wcms.dao.CurtainDao;
import com.wcms.entity.CurtainEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/22.
 */
public class CurtainCrudService {
    private CurtainDao curtainDao;

    private String genNo() {
        List<CurtainEntity> all = curtainDao.findAll();
        Set<String> set = new HashSet<>();
        for (CurtainEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("CL%04d", i);
            if (!set.contains(no)) {
                return no;
            }
        }

    }

    public void add(CurtainEntity entity) throws ServiceException {
        if (entity.getNo() == null || entity.getNo().equals("")) {
            entity.setNo(genNo());
        } else {
            CurtainEntity byNo = curtainDao.findByNo(entity.getNo());
            if (byNo != null) {
                throw new ServiceException("窗帘编号已存在");
            }
        }

        curtainDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        CurtainEntity entity = curtainDao.findById(id);
        if (entity == null) {
            throw new ServiceException("窗帘id不存在");
        }
        curtainDao.delete(entity);
    }

    public void update(CurtainEntity entity) throws ServiceException {
        curtainDao.saveOrUpdate(entity);
    }

    public List<CurtainEntity> findAll() {
        return curtainDao.findAll();
    }

    public CurtainDao getCurtainDao() {
        return curtainDao;
    }

    public void setCurtainDao(CurtainDao curtainDao) {
        this.curtainDao = curtainDao;
    }
}
