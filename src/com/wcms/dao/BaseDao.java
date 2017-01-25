package com.wcms.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
public abstract class BaseDao<T> {

    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Class getEntityClass(){
        Type typeClass1 = getClass().getGenericSuperclass();

        if (typeClass1 instanceof ParameterizedType) {
            Type actualType1 = ((ParameterizedType)typeClass1).getActualTypeArguments()[0];
            try {
                return Class.forName(actualType1.getTypeName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("WRONG ENTITY!");
            }
        } else {
            throw new RuntimeException("WRONG ENTITY!");
        }
    }

    public void save(T entity) {
        getSession().save(entity);
    }

    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public T merge(T entity) {
        return (T) getSession().merge(entity);
    }

    public T findById(Serializable id) {
        return (T) getSession().get(getEntityClass(), id);
    }

    public List<T> findByExample(T entity) {
        return (List<T>) getSession().createCriteria(getEntityClass()).add(Example.create(entity));
    }

    public List<T> findRange(int start, int size) {
        Query query = getSession().createQuery(String.format("from %s", getEntityClass().getSimpleName()));
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    public List<T> findAll() {
        Query query = getSession().createQuery(String.format("from %s", getEntityClass().getSimpleName()));
        return query.list();
    }

    public String test(){
        System.out.println(findAll());
        return "";
    }


}
