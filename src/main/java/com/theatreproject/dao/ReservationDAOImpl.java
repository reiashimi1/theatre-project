package com.theatreproject.dao;

import com.theatreproject.models.Reservation;
import com.theatreproject.utils.EntityManagerProvider;
import com.theatreproject.utils.Helpers;

import javax.persistence.EntityManager;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationDAOImpl implements DAO<Reservation>{

    @Override
    public List<Reservation> index() {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Reservation.findAll", Reservation.class)
                .getResultList();    }

    public List<Reservation> index(BigInteger customerId) {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Reservation.findAllForCustomer", Reservation.class)
                .setParameter("customerId", customerId)
                .getResultList();    }

    public List<Reservation> index(BigInteger customerId, Date filterDate) {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Reservation.findAllForCustomer", Reservation.class)
                .setParameter("customerId", customerId)
                .getResultList()
                .stream()
                .filter((reservation -> Helpers.getInstance().getDateToString(reservation.getShow().getShowdate())
                        .equals(Helpers.getInstance().getDateToString(filterDate))))
                .collect(Collectors.toList());    }

    public List<Reservation> indexCustomer(BigInteger customerId) {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Reservation.findAll", Reservation.class)
//                .setParameter("customerId", customerId)
                .getResultList();    }

    @Override
    public Reservation show(Object key) {
        return EntityManagerProvider.getEntityManager().find(Reservation.class, key);
    }

    @Override
    public void store(Reservation reservation) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(reservation);
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
    public void update(Reservation reservation) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(reservation);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception ignored) {
            }
            e.printStackTrace();
        }
        entityManager.close();
    }

    @Override
    public void destroy(Reservation reservation) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(reservation);
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
