package com.wcms.web.action;

import com.wcms.entity.CustomerEntity;
import com.wcms.model.Result;
import com.wcms.service.CustomerCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/21.
 */
public class CustomerCrudAction extends BaseAction {

    private CustomerCrudService customerCrudService;

    public String getall() {
        List<CustomerEntity> list = customerCrudService.findAll();
        sendResult(list);
        return NONE;
    }

    public String add() {
        CustomerEntity entity = getRequest(CustomerEntity.class);
        Result result = new Result();
        try {
            customerCrudService.add(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String remove() {
        CustomerEntity entity = getRequest(CustomerEntity.class);
        Result result = new Result();
        try {
            customerCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        CustomerEntity entity = getRequest(CustomerEntity.class);
        Result result = new Result();
        try {
            customerCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public CustomerCrudService getCustomerCrudService() {
        return customerCrudService;
    }

    public void setCustomerCrudService(CustomerCrudService customerCrudService) {
        this.customerCrudService = customerCrudService;
    }
}
