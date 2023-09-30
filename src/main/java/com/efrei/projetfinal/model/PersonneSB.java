package com.efrei.projetfinal.model;

import com.efrei.projetfinal.Personne;
import com.efrei.projetfinal.Utilisateur;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class PersonneSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @PersistenceContext
    private EntityManager entityManager;

    public Personne createPersonne(String nom, String prenom, String adresseElectronique, String telephone) {
        Personne personne = new Personne(nom, prenom, adresseElectronique, telephone);
        entityManager.persist(personne);
        return personne;
    }


}
