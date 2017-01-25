package com.wcms.web.action;

import com.wcms.entity.ProcurementDetailEntity;
import com.wcms.model.Result;
import com.wcms.service.ProcurementDetailCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class ProcurementDetailCrudAction extends BaseAction {
    private ProcurementDetailCrudService procurementDetailCrudService;

    public String getall() {
        Result<List<ProcurementDetailEntity>> result = new Result();
        List<ProcurementDetailEntity> list = procurementDetailCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String findByProcurementId() {
        Result<List<ProcurementDetailEntity>> result = new Result();
        ProcurementDetailEntity request = getRequest(ProcurementDetailEntity.class);
        try {
            List<ProcurementDetailEntity> byProcurementId = procurementDetailCrudService.findByProcurementId(request.getProcurement().getId());
            result.setData(byProcurementId);
        } catch (Exception e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String add() {
        try {
            ProcurementDetailEntity entity = getRequest(ProcurementDetailEntity.class);
            Result<ProcurementDetailEntity> result = new Result();
            try {
                procurementDetailCrudService.add(entity);
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
        ProcurementDetailEntity entity = getRequest(ProcurementDetailEntity.class);
        Result result = new Result();
        try {
            procurementDetailCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        ProcurementDetailEntity entity = getRequest(ProcurementDetailEntity.class);
        Result result = new Result();
        try {
            procurementDetailCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public ProcurementDetailCrudService getProcurementDetailCrudService() {
        return procurementDetailCrudService;
    }

    public void setProcurementDetailCrudService(ProcurementDetailCrudService ProcurementDetailCrudService) {
        this.procurementDetailCrudService = ProcurementDetailCrudService;
    }
}
