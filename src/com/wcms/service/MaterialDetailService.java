package com.wcms.service;

import com.wcms.dao.ProcurementDetailDao;
import com.wcms.dao.ReturnDetailDao;
import com.wcms.entity.MaterialEntity;
import com.wcms.entity.ProcurementDetailEntity;
import com.wcms.entity.ReturnDetailEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/1.
 */
public class MaterialDetailService {
    private ProcurementDetailDao procurementDetailDao;
    private ReturnDetailDao returnDetailDao;

    public class MaterialDetailModel {
        int id;
        String no;
        String name;
        String category;
        String model;
        String unit;
        Double price;
        String producingArea;
        String ingredient;
        int counts;
    }

    public List<MaterialDetailModel> getall() {
        Map<Integer, MaterialDetailModel> result = new HashMap<>();
        List<ProcurementDetailEntity> pd = procurementDetailDao.findAll();
        List<ReturnDetailEntity> rd = returnDetailDao.findAll();
        for (ProcurementDetailEntity entity : pd) {
            MaterialEntity material = entity.getMaterial();
            if (result.containsKey(material.getId())) {
                result.get(material.getId()).counts += entity.getCounts();
            } else {
                MaterialDetailModel value = new MaterialDetailModel();
                value.id = material.getId();
                value.no = material.getNo();
                value.name = material.getName();
                value.category = material.getCategory();
                value.model = material.getModel();
                value.unit = material.getUnit();
                value.price = material.getPrice();
                value.producingArea = material.getProducingArea();
                value.ingredient = material.getIngredient();
                value.counts = entity.getCounts();
                result.put(material.getId(), value);
            }
        }
        for (ReturnDetailEntity entity : rd) {
            MaterialEntity material = entity.getMaterial();
            if (result.containsKey(material.getId())) {
                result.get(material.getId()).counts -= entity.getCounts();
            } else {
                MaterialDetailModel value = new MaterialDetailModel();
                value.id = material.getId();
                value.no = material.getNo();
                value.name = material.getName();
                value.category = material.getCategory();
                value.model = material.getModel();
                value.unit = material.getUnit();
                value.price = material.getPrice();
                value.producingArea = material.getProducingArea();
                value.ingredient = material.getIngredient();
                value.counts = entity.getCounts();
                result.put(material.getId(), value);
            }
        }
        List<MaterialDetailModel> re = new ArrayList<>();
        for (int key : result.keySet()) {
            re.add(result.get(key));
        }
        return re;
    }

    public ProcurementDetailDao getProcurementDetailDao() {
        return procurementDetailDao;
    }

    public void setProcurementDetailDao(ProcurementDetailDao procurementDetailDao) {
        this.procurementDetailDao = procurementDetailDao;
    }

    public ReturnDetailDao getReturnDetailDao() {
        return returnDetailDao;
    }

    public void setReturnDetailDao(ReturnDetailDao returnDetailDao) {
        this.returnDetailDao = returnDetailDao;
    }
}
