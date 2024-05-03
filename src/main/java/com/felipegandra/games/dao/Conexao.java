package com.felipegandra.games.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("games");

    public static EntityManager getEntityManager(){
        return EMF.createEntityManager();
    }
}
