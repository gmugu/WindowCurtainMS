package com.wcms.web.action;

import com.wcms.entity.SalaryEntity;
import com.wcms.model.Result;
import com.wcms.service.SalaryCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class SalaryCrudAction extends BaseAction {
    private SalaryCrudService salaryCrudService;

    public String getall() {
        Result<List<SalaryEntity>> result = new Result();
        List<SalaryEntity> list = salaryCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        try {
            SalaryEntity entity = getRequest(SalaryEntity.class);
            Result<SalaryEntity> result = new Result();
            try {
                salaryCrudService.add(entity);
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
        SalaryEntity entity = getRequest(SalaryEntity.class);
        Result result = new Result();
        try {
            salaryCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        SalaryEntity entity = getRequest(SalaryEntity.class);
        Result result = new Result();
        try {
            salaryCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public SalaryCrudService getSalaryCrudService() {
        return salaryCrudService;
    }

    public void setSalaryCrudService(SalaryCrudService SalaryCrudService) {
        this.salaryCrudService = SalaryCrudService;
    }
}
