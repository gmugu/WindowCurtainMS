package com.wcms.service;

import com.wcms.dao.MaterialDao;
import com.wcms.entity.MaterialEntity;
import com.wcms.service.exception.ServiceException;

import java.util.*;

/**
 * Created by Administrator on 2017/1/22.
 */
public class MaterialCrudService {
    private MaterialDao materialDao;

    private String genNo() {
        List<MaterialEntity> all = materialDao.findAll();
        Set<String> set = new HashSet<>();
        for (MaterialEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("CL%03d", i);
            if (!set.contains(no)) {
                return no;
            }
        }

    }


    public Map<String, String> getMaterialOpt() {
        Map<String, String> map = new HashMap<>();
        List<MaterialEntity> list = materialDao.findAll();
        for (MaterialEntity e : list) {
            map.put(e.getId() + "", e.getNo() + ":" + e.getName());
        }
        return map;
    }

    public void add(MaterialEntity entity) throws ServiceException {
        if (entity.getNo() == null || entity.getNo().equals("")) {
            entity.setNo(genNo());
        } else {
            MaterialEntity byNo = materialDao.findByNo(entity.getNo());
            if (byNo != null) {
                throw new ServiceException("材料编号已存在");
            }
        }

        materialDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        MaterialEntity entity = materialDao.findById(id);
        if (entity == null) {
            throw new ServiceException("材料id不存在");
        }
        materialDao.delete(entity);
    }

    public void update(MaterialEntity entity) throws ServiceException {
        materialDao.saveOrUpdate(entity);
    }

    public List<MaterialEntity> findAll() {
        return materialDao.findAll();
    }

    public MaterialDao getMaterialDao() {
        return materialDao;
    }

    public void setMaterialDao(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }
}
