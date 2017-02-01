package com.wcms.web.action;

import com.wcms.entity.EmployeeEntity;
import com.wcms.model.Result;
import com.wcms.service.EmployeeCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/21.
 */
public class EmployeeCrudAction extends BaseAction {

    private EmployeeCrudService employeeCrudService;

    public String getall() {
        Result<List<EmployeeEntity>> result = new Result();
        List<EmployeeEntity> list = employeeCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        Result<EmployeeEntity> result = new Result();
        try {
            EmployeeEntity entity = getRequest(EmployeeEntity.class);
            employeeCrudService.add(entity);
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
        Result result = new Result();
        try {
            EmployeeEntity entity = getRequest(EmployeeEntity.class);
            employeeCrudService.delete(entity.getId());
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        Result result = new Result();
        try {
            EmployeeEntity entity = getRequest(EmployeeEntity.class);
            employeeCrudService.update(entity);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public EmployeeCrudService getEmployeeCrudService() {
        return employeeCrudService;
    }

    public void setEmployeeCrudService(EmployeeCrudService EmployeeCrudService) {
        this.employeeCrudService = EmployeeCrudService;
    }
}
