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

    public PersonneEntity createPersonne(String nom, String prenom, String adresseElectronique, String telephone) {
        PersonneEntity newPersonne = new PersonneEntity();
        newPersonne.setNom(nom);
        newPersonne.setPrenom(prenom);
        newPersonne.setAdresseElectronique(adresseElectronique);
        newPersonne.setTelephone(telephone);

        em.persist(newPersonne);
        em.flush();

        return newPersonne;
    }




}
