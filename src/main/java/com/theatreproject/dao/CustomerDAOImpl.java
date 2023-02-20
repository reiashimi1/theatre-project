package com.theatreproject.dao;

import com.theatreproject.utils.EntityManagerProvider;
import com.theatreproject.models.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public List<Customer> index() {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Customer.findAll", Customer.class)
                .getResultList();
    }

    @Override
    public Customer show(Object key) {
        return EntityManagerProvider.getEntityManager().find(Customer.class, key);
    }

    @Override
    public void store(Customer customer) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
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
    public void update(Customer customer) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(customer);
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
    public void destroy(Customer customer) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(customer);
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
    public Customer authenticate(String username, String password) {
        return EntityManagerProvider.getEntityManager()
                .createNamedQuery("Customer.authenticate", Customer.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
    }
}
