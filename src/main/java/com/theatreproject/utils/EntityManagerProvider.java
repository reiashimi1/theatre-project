package com.theatreproject.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    public static final String PU_NAME;

    static {
        PU_NAME = "persistenceUnit";
    }

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PU_NAME);
        return factory.createEntityManager();
    }
}
