package com.wcms.service;

import com.wcms.dao.EmployeeDao;
import com.wcms.dao.ReturnlDao;
import com.wcms.dao.SupplierDao;
import com.wcms.dao.WarehouseDao;
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
    private EmployeeDao employeeDao;
    private WarehouseDao warehouseDao;
    private SupplierDao supplierDao;


    private String genNo() {
        List<ReturnlEntity> all = returnlDao.findAll();
        Set<String> set = new HashSet<>();
        for (ReturnlEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("TH%03d", i);
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
        entity.setOperator(employeeDao.findByNo(entity.getOperator().getNo()));
        entity.setWarehouse(warehouseDao.findByNo(entity.getWarehouse().getNo()));
        entity.setSupplier(supplierDao.findByNo(entity.getSupplier().getNo()));
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
        entity.setOperator(employeeDao.findByNo(entity.getOperator().getNo()));
        entity.setWarehouse(warehouseDao.findByNo(entity.getWarehouse().getNo()));
        entity.setSupplier(supplierDao.findByNo(entity.getSupplier().getNo()));
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
