package com.wcms.web.action;

import com.wcms.entity.BusinessEntity;
import com.wcms.entity.OrderlEntity;
import com.wcms.model.Result;
import com.wcms.service.BusinessCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.ArrayList;
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
        Result<BusinessEntity> result = new Result();
        try {
            BusinessEntity entity = getRequest(BusinessEntity.class);
            businessCrudService.add(entity);
            result.setData(entity);
        } catch (Exception e) {
            e.printStackTrace();
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

    public String signGetall() throws Exception {
        Result<List<BusinessEntity>> result = new Result();
        List<BusinessEntity> list = businessCrudService.findAll();
        List<BusinessEntity> re = new ArrayList<>();
        for (BusinessEntity entity : list) {
            if ("已派工".equals(entity.getState())) {
                re.add(entity);
            }
        }
        result.setData(re);
        sendResult(result);
        return NONE;
    }

    public String signAdd() throws Exception {
        Result<BusinessEntity> result = new Result();
        try {
            BusinessEntity entity = getRequest(BusinessEntity.class);
            entity = businessCrudService.signAdd(entity);
            result.setData(entity);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String signRemove() throws Exception {
        BusinessEntity entity = getRequest(BusinessEntity.class);
        Result result = new Result();
        try {
            businessCrudService.signDelete(entity.getId());
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String signUpdate() throws Exception {
        BusinessEntity entity = getRequest(BusinessEntity.class);
        Result<BusinessEntity> result = new Result();
        try {
            entity = businessCrudService.signUpdate(entity);
            result.setData(entity);
        } catch (Exception e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }
}
