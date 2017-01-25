package com.wcms.service;

import com.wcms.dao.MaterialDao;
import com.wcms.dao.ProcurementDao;
import com.wcms.dao.ProcurementDetailDao;
import com.wcms.entity.ProcurementDetailEntity;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/23.
 */
public class ProcurementDetailCrudService {
    private ProcurementDetailDao procurementDetailDao;
    private ProcurementDao procurementDao;
    private MaterialDao materialDao;


    public void add(ProcurementDetailEntity entity) throws ServiceException {
        entity.setProcurement(procurementDao.findById(entity.getProcurement().getId()));
        entity.setMaterial(materialDao.findByNo(entity.getMaterial().getNo()));
        procurementDetailDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        ProcurementDetailEntity entity = procurementDetailDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        procurementDetailDao.delete(entity);
    }

    public void update(ProcurementDetailEntity entity) throws ServiceException {
        ProcurementDetailEntity byId = procurementDetailDao.findById(entity.getId());
        byId.setMaterial(materialDao.findByNo(entity.getMaterial().getNo()));
        byId.setCounts(entity.getCounts());
        procurementDetailDao.saveOrUpdate(byId);
    }

    public List<ProcurementDetailEntity> findAll() {
        return procurementDetailDao.findAll();
    }


    public ProcurementDetailDao getProcurementDetailDao() {
        return procurementDetailDao;
    }

    public void setProcurementDetailDao(ProcurementDetailDao procurementDetailDao) {
        this.procurementDetailDao = procurementDetailDao;
    }

    public List<ProcurementDetailEntity> findByProcurementId(int id) {
        return procurementDetailDao.findByProcurementId(id);
    }

    public ProcurementDao getProcurementDao() {
        return procurementDao;
    }

    public void setProcurementDao(ProcurementDao procurementDao) {
        this.procurementDao = procurementDao;
    }

    public MaterialDao getMaterialDao() {
        return materialDao;
    }

    public void setMaterialDao(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }
}
