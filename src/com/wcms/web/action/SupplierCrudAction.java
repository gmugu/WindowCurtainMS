package com.wcms.web.action;

import com.wcms.entity.SupplierEntity;
import com.wcms.model.Result;
import com.wcms.service.SupplierCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class SupplierCrudAction extends BaseAction {
    private SupplierCrudService supplierCrudService;

    public String getall() {
        Result<List<SupplierEntity>> result = new Result();
        List<SupplierEntity> list = supplierCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        SupplierEntity entity = getRequest(SupplierEntity.class);
        Result<SupplierEntity> result = new Result();
        try {
            supplierCrudService.add(entity);
            result.setData(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String remove() {
        SupplierEntity entity = getRequest(SupplierEntity.class);
        Result result = new Result();
        try {
            supplierCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        SupplierEntity entity = getRequest(SupplierEntity.class);
        Result result = new Result();
        try {
            supplierCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public SupplierCrudService getSupplierCrudService() {
        return supplierCrudService;
    }

    public void setSupplierCrudService(SupplierCrudService supplierCrudService) {
        this.supplierCrudService = supplierCrudService;
    }
}
