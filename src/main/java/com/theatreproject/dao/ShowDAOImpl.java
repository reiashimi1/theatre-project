package com.theatreproject.dao;

import com.theatreproject.models.Show;
import com.theatreproject.utils.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;

public class ShowDAOImpl implements DAO<Show>{

    @Override
    public List<Show> index() {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Show.findAll", Show.class)
                .getResultList();
    }

    @Override
    public Show show(Object key) {
        return EntityManagerProvider.getEntityManager().find(Show.class, key);
    }

    @Override
    public void store(Show show) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(show);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception ignored) {
            }
        }
        entityManager.close();
    }

    @Override
    public void update(Show show) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(show);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception ignored) {
            }
        }
        entityManager.close();

    }

    @Override
    public void destroy(Show show) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(show);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception ignored) {
            }
        }
        entityManager.close();

    }
}
