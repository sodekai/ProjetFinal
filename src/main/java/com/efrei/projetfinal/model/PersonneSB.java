package com.efrei.projetfinal.model;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class PersonneSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @PersistenceContext
    private EntityManager entityManager;

    public void createPersonne(String nom, String prenom, String adresseElectronique, String telephone) {
        Query qCreatePersonne = em.createNativeQuery(
                        "insert into PersonneEntity (nom, prenom, adresseElectronique, telephone) VALUES (:nom, :prenom, :adresseElectronique, :telephone)")
                .setParameter("nom", nom)
                .setParameter("prenom", prenom)
                .setParameter("adresseElectronique", adresseElectronique)
                .setParameter("telephone", telephone);

    }


}
