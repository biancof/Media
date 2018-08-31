package com.m2i.poe.media;

import javax.persistence.*;

public class EntityManagerFactorySingleton {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    private EntityManagerFactorySingleton() {
    }

    public static EntityManagerFactory getEMF(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("FormationJPA");
        }
        return emf;
    }

    public static EntityManager getEM(){
        if (em == null){
            em = getEMF().createEntityManager();
        }
        return em;
    }
}
