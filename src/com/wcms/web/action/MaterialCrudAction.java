package com.wcms.web.action;

import com.wcms.entity.MaterialEntity;
import com.wcms.model.Result;
import com.wcms.service.MaterialCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class MaterialCrudAction extends BaseAction {
    private MaterialCrudService materialCrudService;

    public String getall() {
        Result<List<MaterialEntity>> result = new Result();
        List<MaterialEntity> list = materialCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        try {
            MaterialEntity entity = getRequest(MaterialEntity.class);
            Result<MaterialEntity> result = new Result();
            try {
                materialCrudService.add(entity);
                result.setData(entity);
            } catch (ServiceException e) {
                result.setCode(1);
                result.setMsg(e.getMessage());
            }
            sendResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NONE;
    }

    public String remove() {
        MaterialEntity entity = getRequest(MaterialEntity.class);
        Result result = new Result();
        try {
            materialCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        MaterialEntity entity = getRequest(MaterialEntity.class);
        Result result = new Result();
        try {
            materialCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public MaterialCrudService getMaterialCrudService() {
        return materialCrudService;
    }

    public void setMaterialCrudService(MaterialCrudService materialCrudService) {
        this.materialCrudService = materialCrudService;
    }
}
