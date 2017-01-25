package com.wcms.web.action;

import com.wcms.entity.ReturnDetailEntity;
import com.wcms.model.Result;
import com.wcms.service.ReturnDetailCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class ReturnDetailCrudAction extends BaseAction {
    private ReturnDetailCrudService returnDetailCrudService;

    public String getall() {
        Result<List<ReturnDetailEntity>> result = new Result();
        List<ReturnDetailEntity> list = returnDetailCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        try {
            ReturnDetailEntity entity = getRequest(ReturnDetailEntity.class);
            Result<ReturnDetailEntity> result = new Result();
            try {
                returnDetailCrudService.add(entity);
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
        ReturnDetailEntity entity = getRequest(ReturnDetailEntity.class);
        Result result = new Result();
        try {
            returnDetailCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        ReturnDetailEntity entity = getRequest(ReturnDetailEntity.class);
        Result result = new Result();
        try {
            returnDetailCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public ReturnDetailCrudService getReturnDetailCrudService() {
        return returnDetailCrudService;
    }

    public void setReturnDetailCrudService(ReturnDetailCrudService ReturnDetailCrudService) {
        this.returnDetailCrudService = ReturnDetailCrudService;
    }
}
