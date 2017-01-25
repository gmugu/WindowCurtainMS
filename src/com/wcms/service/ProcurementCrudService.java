package com.wcms.service;

import com.wcms.dao.EmployeeDao;
import com.wcms.dao.ProcurementDao;
import com.wcms.dao.SupplierDao;
import com.wcms.dao.WarehouseDao;
import com.wcms.entity.ProcurementEntity;
import com.wcms.service.exception.ServiceException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/23.
 */
public class ProcurementCrudService {

    private ProcurementDao procurementDao;
    private EmployeeDao employeeDao;
    private WarehouseDao warehouseDao;
    private SupplierDao supplierDao;

    private String genNo() {
        List<ProcurementEntity> all = procurementDao.findAll();
        Set<String> set = new HashSet<>();
        for (ProcurementEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("CG%03d", i);
            if (!set.contains(no)) {
                return no;
            }
        }

    }

    public void add(ProcurementEntity entity) throws ServiceException {
        if (entity.getNo() == null || entity.getNo().equals("")) {
            entity.setNo(genNo());
        } else {
            ProcurementEntity byNo = procurementDao.findByNo(entity.getNo());
            if (byNo != null) {
                throw new ServiceException("采购号已存在");
            }
        }
        entity.setOperator(employeeDao.findByNo(entity.getOperator().getNo()));
        entity.setWarehouse(warehouseDao.findByNo(entity.getWarehouse().getNo()));
        entity.setSupplier(supplierDao.findByNo(entity.getSupplier().getNo()));
        procurementDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        ProcurementEntity entity = procurementDao.findById(id);
        if (entity == null) {
            throw new ServiceException("采购id不存在");
        }
        procurementDao.delete(entity);
    }

    public void update(ProcurementEntity entity) throws ServiceException {
        entity.setOperator(employeeDao.findByNo(entity.getOperator().getNo()));
        entity.setWarehouse(warehouseDao.findByNo(entity.getWarehouse().getNo()));
        entity.setSupplier(supplierDao.findByNo(entity.getSupplier().getNo()));
        procurementDao.saveOrUpdate(entity);
    }

    public List<ProcurementEntity> findAll() {
        return procurementDao.findAll();
    }


    public ProcurementDao getProcurementDao() {
        return procurementDao;
    }

    public void setProcurementDao(ProcurementDao procurementDao) {
        this.procurementDao = procurementDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public WarehouseDao getWarehouseDao() {
        return warehouseDao;
    }

    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    public SupplierDao getSupplierDao() {
        return supplierDao;
    }

    public void setSupplierDao(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }
}
