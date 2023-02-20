package com.theatreproject.dao;

import com.theatreproject.models.Actor;
import com.theatreproject.utils.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;

public class ActorDAOImpl implements DAO<Actor> {
    @Override
    public List<Actor> index() {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Actor.findAll", Actor.class)
                .getResultList();    }

    public List<Actor> index(BigInteger playId) {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Actor.findAllForPlay", Actor.class)
                .setParameter("playId", playId)
                .getResultList();    }

    @Override
    public Actor show(Object key) {
        return EntityManagerProvider.getEntityManager().find(Actor.class, key);
    }

    @Override
    public void store(Actor actor) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(actor);
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
    public void update(Actor actor) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(actor);
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
    public void destroy(Actor actor) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(actor);
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
