package com.wcms.web.action;

import com.wcms.entity.ReturnlEntity;
import com.wcms.model.Result;
import com.wcms.service.ReturnCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class ReturnCrudAction extends BaseAction {
    private ReturnCrudService returnCrudService;

    public String getall() {
        Result<List<ReturnlEntity>> result = new Result();
        List<ReturnlEntity> list = returnCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        try {
            ReturnlEntity entity = getRequest(ReturnlEntity.class);
            Result<ReturnlEntity> result = new Result();
            try {
                returnCrudService.add(entity);
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
        ReturnlEntity entity = getRequest(ReturnlEntity.class);
        Result result = new Result();
        try {
            returnCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        ReturnlEntity entity = getRequest(ReturnlEntity.class);
        Result result = new Result();
        try {
            returnCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public ReturnCrudService getReturnCrudService() {
        return returnCrudService;
    }

    public void setReturnCrudService(ReturnCrudService ReturnCrudService) {
        this.returnCrudService = ReturnCrudService;
    }
}
