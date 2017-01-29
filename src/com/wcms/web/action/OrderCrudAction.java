package com.wcms.web.action;

import com.wcms.entity.OrderlEntity;
import com.wcms.model.Result;
import com.wcms.service.OrderCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class OrderCrudAction extends BaseAction {
    private OrderCrudService orderCrudService;

    public String getall() {
        Result<List<OrderlEntity>> result = new Result();
        List<OrderlEntity> list = orderCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        try {
            OrderlEntity entity = getRequest(OrderlEntity.class);
            Result<OrderlEntity> result = new Result();
            try {
                orderCrudService.add(entity);
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
        OrderlEntity entity = getRequest(OrderlEntity.class);
        Result result = new Result();
        try {
            orderCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        OrderlEntity entity = getRequest(OrderlEntity.class);
        Result result = new Result();
        try {
            orderCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public OrderCrudService getOrderCrudService() {
        return orderCrudService;
    }

    public void setOrderCrudService(OrderCrudService OrderCrudService) {
        this.orderCrudService = OrderCrudService;
    }

    public String signAdd() throws Exception {
        Result<OrderlEntity> result = new Result();
        try {
            OrderlEntity entity = getRequest(OrderlEntity.class);
            entity = orderCrudService.signAdd(entity);
            result.setData(entity);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String signUpdate() throws Exception {
        OrderlEntity entity = getRequest(OrderlEntity.class);
        Result<OrderlEntity> result = new Result();
        try {
            entity = orderCrudService.signUpdate(entity);
            result.setData(entity);
        } catch (Exception e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String signGetall() throws Exception {
        Result<List<OrderlEntity>> result = new Result();
        List<OrderlEntity> list = orderCrudService.findAll();
        List<OrderlEntity> resultD = new ArrayList<>();
        for (OrderlEntity entity : list) {
            if (entity.getState().equals("签收")) {
                resultD.add(entity);
            }
        }
        result.setData(resultD);
        sendResult(result);
        return NONE;
    }

    public String signRemove() throws Exception {
        OrderlEntity entity = getRequest(OrderlEntity.class);
        Result result = new Result();
        try {
            orderCrudService.signDelete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }
}
