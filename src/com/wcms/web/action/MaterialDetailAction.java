package com.wcms.web.action;

import com.wcms.model.Result;
import com.wcms.service.MaterialDetailService;

import java.util.List;

/**
 * Created by Administrator on 2017/2/1.
 */
public class MaterialDetailAction extends BaseAction {
    private MaterialDetailService materialDetailService;

    @Override
    public String execute() throws Exception {
        Result<List<MaterialDetailService.MaterialDetailModel>> result = new Result();
        List<MaterialDetailService.MaterialDetailModel> list = materialDetailService.getall();
        result.setData(list);
        sendResult(result);

        return NONE;
    }

    public MaterialDetailService getMaterialDetailService() {
        return materialDetailService;
    }

    public void setMaterialDetailService(MaterialDetailService materialDetailService) {
        this.materialDetailService = materialDetailService;
    }
}
