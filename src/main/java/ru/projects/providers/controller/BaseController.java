package ru.projects.providers.controller;

import org.hibernate.Session;
import ru.projects.dictionary.Service;
import ru.projects.utils.HibernateUtils;

public abstract class BaseController {

    private Session currentSession;

    protected BaseController(Service service) {
        currentSession = HibernateUtils.openSession(service);
    }

    protected synchronized Session getClearSession() {
        currentSession.clear();
        return currentSession;
    }

    public synchronized <T> T getById(Class<T> tClass, long id) {
        return getClearSession().get(tClass, id);
    }

    public <T> T getLast(Class<T> tClass) {
        return getClearSession().createQuery("FROM " + tClass.getSimpleName() + " order by id desc",
            tClass).setMaxResults(1).getSingleResult();
    }

    public void update(String query) {
        Session session = getClearSession();
        session.beginTransaction();
        session.createQuery(query).executeUpdate();
        session.getTransaction().commit();
    }
}


