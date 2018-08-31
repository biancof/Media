package com.m2i.poe.media;

import com.m2i.poe.media.rest.BookRest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.transform.sax.SAXSource;

public class Main {

    public static  void main(String[] args){

            EntityManagerFactory emf = EntityManagerFactorySingleton.getEMF();
            EntityManager em = emf.createEntityManager();
            Book b = em.find(Book.class, 1);
            System.out.println(b.toString());

    }
}
