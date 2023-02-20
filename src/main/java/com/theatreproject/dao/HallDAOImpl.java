package com.theatreproject.dao;

import com.theatreproject.models.Hall;
import com.theatreproject.utils.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;

public class HallDAOImpl implements DAO<Hall> {

    @Override
    public List<Hall> index() {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Hall.findAll", Hall.class)
                .getResultList();
    }

    @Override
    public Hall show(Object key) {
        return EntityManagerProvider.getEntityManager().find(Hall.class, key);
    }

    @Override
    public void store(Hall hall) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(hall);
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
    public void update(Hall hall) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(hall);
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
    public void destroy(Hall hall) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(hall);
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
