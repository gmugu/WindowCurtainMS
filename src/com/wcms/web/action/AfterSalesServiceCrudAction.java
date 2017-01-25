package com.wcms.web.action;

import com.wcms.entity.AfterSalesServiceEntity;
import com.wcms.model.Result;
import com.wcms.service.AfterSalesServiceCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/23.
 */
public class AfterSalesServiceCrudAction extends BaseAction {
    private AfterSalesServiceCrudService afterSalesServiceCrudService;


    public String getall() {
        Result<List<AfterSalesServiceEntity>> result = new Result();
        List<AfterSalesServiceEntity> list = afterSalesServiceCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        AfterSalesServiceEntity entity = getRequest(AfterSalesServiceEntity.class);
        Result<AfterSalesServiceEntity> result = new Result();
        try {
            afterSalesServiceCrudService.add(entity);
            result.setData(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String remove() {
        AfterSalesServiceEntity entity = getRequest(AfterSalesServiceEntity.class);
        Result result = new Result();
        try {
            afterSalesServiceCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        AfterSalesServiceEntity entity = getRequest(AfterSalesServiceEntity.class);
        Result result = new Result();
        try {
            afterSalesServiceCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public AfterSalesServiceCrudService getAfterSalesServiceCrudService() {
        return afterSalesServiceCrudService;
    }

    public void setAfterSalesServiceCrudService(AfterSalesServiceCrudService afterSalesServiceCrudService) {
        this.afterSalesServiceCrudService = afterSalesServiceCrudService;
    }
}
