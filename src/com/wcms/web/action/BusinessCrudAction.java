package com.wcms.web.action;

import com.wcms.entity.BusinessEntity;
import com.wcms.model.Result;
import com.wcms.service.BusinessCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/23.
 */
public class BusinessCrudAction extends BaseAction {

    private BusinessCrudService businessCrudService;
    public String getall() {
        Result<List<BusinessEntity>> result = new Result();
        List<BusinessEntity> list = businessCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        BusinessEntity entity = getRequest(BusinessEntity.class);
        Result<BusinessEntity> result = new Result();
        try {
            businessCrudService.add(entity);
            result.setData(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String remove() {
        BusinessEntity entity = getRequest(BusinessEntity.class);
        Result result = new Result();
        try {
            businessCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        BusinessEntity entity = getRequest(BusinessEntity.class);
        Result result = new Result();
        try {
            businessCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public BusinessCrudService getBusinessCrudService() {
        return businessCrudService;
    }

    public void setBusinessCrudService(BusinessCrudService businessCrudService) {
        this.businessCrudService = businessCrudService;
    }
}
