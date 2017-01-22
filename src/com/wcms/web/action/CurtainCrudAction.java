package com.wcms.web.action;

import com.wcms.entity.CurtainEntity;
import com.wcms.model.Result;
import com.wcms.service.CurtainCrudService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class CurtainCrudAction extends BaseAction {

    private CurtainCrudService curtainCrudService;

    public String getall() {
        Result<List<CurtainEntity>> result = new Result();
        List<CurtainEntity> list = curtainCrudService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() {
        CurtainEntity entity = getRequest(CurtainEntity.class);
        Result<CurtainEntity> result = new Result();
        try {
            curtainCrudService.add(entity);
            result.setData(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String remove() {
        CurtainEntity entity = getRequest(CurtainEntity.class);
        Result result = new Result();
        try {
            curtainCrudService.delete(entity.getId());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() {
        CurtainEntity entity = getRequest(CurtainEntity.class);
        Result result = new Result();
        try {
            curtainCrudService.update(entity);
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }
    
    public CurtainCrudService getCurtainCrudService() {
        return curtainCrudService;
    }

    public void setCurtainCrudService(CurtainCrudService curtainCrudService) {
        this.curtainCrudService = curtainCrudService;
    }
}
