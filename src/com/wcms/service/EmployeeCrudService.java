package com.wcms.service;

import com.wcms.dao.EmployeeDao;
import com.wcms.entity.EmployeeEntity;
import com.wcms.service.exception.ServiceException;

import java.util.*;

/**
 * Created by Administrator on 2017/1/23.
 */
public class EmployeeCrudService {
    private EmployeeDao employeeDao;

    private String genNo() {
        List<EmployeeEntity> all = employeeDao.findAll();
        Set<String> set = new HashSet<>();
        for (EmployeeEntity e : all) {
            set.add(e.getNo());
        }
        for (int i = 1; ; i++) {
            String no = String.format("YG%03d", i);
            if (!set.contains(no)) {
                return no;
            }
        }

    }

    public Map<String, String> getEmployeeOpt() {
        Map<String, String> map = new HashMap<>();
        List<EmployeeEntity> list = employeeDao.findAll();
        for (EmployeeEntity e : list) {
            map.put(e.getId()+"", e.getNo() + ":" + e.getName());
        }
        return map;
    }

    public void add(EmployeeEntity entity) throws ServiceException {
        if (entity.getNo() == null || entity.getNo().equals("")) {
            entity.setNo(genNo());
        } else {
            EmployeeEntity byNo = employeeDao.findByNo(entity.getNo());
            if (byNo != null) {
                throw new ServiceException("编号已存在");
            }
        }

        employeeDao.save(entity);
    }

    public void delete(int id) throws ServiceException {
        EmployeeEntity entity = employeeDao.findById(id);
        if (entity == null) {
            throw new ServiceException("id不存在");
        }
        employeeDao.delete(entity);
    }

    public void update(EmployeeEntity entity) throws ServiceException {
        employeeDao.saveOrUpdate(entity);
    }

    public List<EmployeeEntity> findAll() {
        return employeeDao.findAll();
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
