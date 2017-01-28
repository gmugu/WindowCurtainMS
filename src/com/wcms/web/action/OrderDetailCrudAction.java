package com.wcms.web.action;

import com.wcms.entity.OrderDetailEntity;
import com.wcms.model.Result;
import com.wcms.service.OrderDetailCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class OrderDetailCrudAction extends BaseAction {
    private OrderDetailCrudService orderDetailCrudService;

    public String getall() {
        Result<List<OrderDetailEntity>> result = new Result();
        List<OrderDetailEntity> list = orderDetailCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        try {
            OrderDetailEntity entity = getRequest(OrderDetailEntity.class);
            Result<OrderDetailEntity> result = new Result();
            try {
                orderDetailCrudService.add(entity);
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
        OrderDetailEntity entity = getRequest(OrderDetailEntity.class);
        Result result = new Result();
        try {
            orderDetailCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        OrderDetailEntity entity = getRequest(OrderDetailEntity.class);
        Result result = new Result();
        try {
            orderDetailCrudService.update(entity);
        } catch (Exception e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public OrderDetailCrudService getOrderDetailCrudService() {
        return orderDetailCrudService;
    }

    public void setOrderDetailCrudService(OrderDetailCrudService OrderDetailCrudService) {
        this.orderDetailCrudService = OrderDetailCrudService;
    }

    public String findByOrderId() throws Exception {
        Result<List<OrderDetailEntity>> result = new Result();
        OrderDetailEntity request = getRequest(OrderDetailEntity.class);
        try {
            List<OrderDetailEntity> byOrderId = orderDetailCrudService.findByOrderId(request.getOrder().getId());
            result.setData(byOrderId);
        } catch (Exception e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }
}
