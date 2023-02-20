package com.theatreproject.dao;

import com.theatreproject.models.Play;
import com.theatreproject.utils.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;

public class PlayDAOImpl implements DAO<Play>{

    @Override
    public List<Play> index() {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Play.findAll", Play.class)
                .getResultList();
    }

    @Override
    public Play show(Object key) {
        return EntityManagerProvider.getEntityManager().find(Play.class, key);
    }

    @Override
    public void store(Play play) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(play);
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
    public void update(Play play) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(play);
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
    public void destroy(Play play) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(play);
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
