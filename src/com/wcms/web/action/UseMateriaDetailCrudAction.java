package com.wcms.web.action;

import com.wcms.entity.UseMaterialDetailEntity;
import com.wcms.model.Result;
import com.wcms.service.UseMaterialDetailCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class UseMateriaDetailCrudAction extends BaseAction {
    private UseMaterialDetailCrudService useMaterialDetailCrudService;

    public String getall() {
        Result<List<UseMaterialDetailEntity>> result = new Result();
        List<UseMaterialDetailEntity> list = useMaterialDetailCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        try {
            UseMaterialDetailEntity entity = getRequest(UseMaterialDetailEntity.class);
            Result<UseMaterialDetailEntity> result = new Result();
            try {
                useMaterialDetailCrudService.add(entity);
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
        UseMaterialDetailEntity entity = getRequest(UseMaterialDetailEntity.class);
        Result result = new Result();
        try {
            useMaterialDetailCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        UseMaterialDetailEntity entity = getRequest(UseMaterialDetailEntity.class);
        Result result = new Result();
        try {
            useMaterialDetailCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public UseMaterialDetailCrudService getUseMaterialDetailCrudService() {
        return useMaterialDetailCrudService;
    }

    public void setUseMaterialDetailCrudService(UseMaterialDetailCrudService UseMaterialDetailCrudService) {
        this.useMaterialDetailCrudService = UseMaterialDetailCrudService;
    }
}
