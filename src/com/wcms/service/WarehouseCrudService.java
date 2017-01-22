package com.wcms.service;

import com.wcms.dao.WarehouseDao;
import com.wcms.entity.WarehouseEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/22.
 */
public class WarehouseCrudService {
    private WarehouseDao warehouseDao;

    private String genNo() {
        List<WarehouseEntity> all = warehouseDao.findAll();
        Set<String> set = new HashSet<>();
        for (WarehouseEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("CK%04d", i);
            if (!set.contains(no)) {
                return no;
            }
        }

    }

    public void add(WarehouseEntity entity) throws ServiceException {
        if (entity.getNo() == null || entity.getNo().equals("")) {
            entity.setNo(genNo());
        } else {
            WarehouseEntity byNo = warehouseDao.findByNo(entity.getNo());
            if (byNo != null) {
                throw new ServiceException("仓库编号已存在");
            }
        }

        warehouseDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        WarehouseEntity entity = warehouseDao.findById(id);
        if (entity == null) {
            throw new ServiceException("仓库id不存在");
        }
        warehouseDao.delete(entity);
    }

    public void update(WarehouseEntity entity) throws ServiceException {
        warehouseDao.saveOrUpdate(entity);
    }

    public List<WarehouseEntity> findAll() {
        return warehouseDao.findAll();
    }
    public WarehouseDao getWarehouseDao() {
        return warehouseDao;
    }

    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }
}
