package com.wcms.dao;

import com.wcms.entity.OrderlEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
public abstract class BaseDao<T> {
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

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
        return getClass();
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


}
