package com.wcms.web.action;

import com.wcms.entity.WarehouseEntity;
import com.wcms.model.Result;
import com.wcms.service.WarehouseCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class WarehouseCrudAction extends BaseAction {
    private WarehouseCrudService warehouseCrudService;
    public String getall() {
        Result<List<WarehouseEntity>> result = new Result();
        List<WarehouseEntity> list = warehouseCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        WarehouseEntity entity = getRequest(WarehouseEntity.class);
        Result<WarehouseEntity> result = new Result();
        try {
            warehouseCrudService.add(entity);
            result.setData(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String remove() {
        WarehouseEntity entity = getRequest(WarehouseEntity.class);
        Result result = new Result();
        try {
            warehouseCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        WarehouseEntity entity = getRequest(WarehouseEntity.class);
        Result result = new Result();
        try {
            warehouseCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public WarehouseCrudService getWarehouseCrudService() {
        return warehouseCrudService;
    }

    public void setWarehouseCrudService(WarehouseCrudService warehouseCrudService) {
        this.warehouseCrudService = warehouseCrudService;
    }
}
