package com.wcms.web.action;

import com.wcms.entity.ProcurementEntity;
import com.wcms.model.Result;
import com.wcms.service.ProcurementCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class ProcurementCrudAction extends BaseAction {
    private ProcurementCrudService procurementCrudService;

    public String getall() {
        Result<List<ProcurementEntity>> result = new Result();
        List<ProcurementEntity> list = procurementCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        try {
            ProcurementEntity entity = getRequest(ProcurementEntity.class);
            System.out.println(entity);
            Result<ProcurementEntity> result = new Result();
            try {
                procurementCrudService.add(entity);
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
        ProcurementEntity entity = getRequest(ProcurementEntity.class);
        Result result = new Result();
        try {
            procurementCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        ProcurementEntity entity = getRequest(ProcurementEntity.class);
        Result result = new Result();
        try {
            procurementCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public ProcurementCrudService getProcurementCrudService() {
        return procurementCrudService;
    }

    public void setProcurementCrudService(ProcurementCrudService ProcurementCrudService) {
        this.procurementCrudService = ProcurementCrudService;
    }
}
