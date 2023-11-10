package com.efrei.projetfinal.model;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class PersonneSB {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public PersonneEntity createPersonne(String nom, String prenom, String adresseElectronique, String telephone) {
        PersonneEntity newPersonne = new PersonneEntity();
        newPersonne.setNom(nom);
        newPersonne.setPrenom(prenom);
        newPersonne.setAdresseElectronique(adresseElectronique);
        newPersonne.setTelephone(telephone);
        em.getTransaction().begin();
        em.persist(newPersonne);
        em.flush();
        em.getTransaction().commit();
        return newPersonne;
    }

    public PersonneEntity getPersonneById(int idPersonne) {
        TypedQuery<PersonneEntity> query = em.createNamedQuery("PersonneEntity.findById", PersonneEntity.class);
        query.setParameter("idPersonne", idPersonne);
        return query.getSingleResult();
    }

    public List<PersonneEntity> getAllPersonnes() {
        TypedQuery<PersonneEntity> query = em.createNamedQuery("PersonneEntity.findAll", PersonneEntity.class);
        return query.getResultList();
    }

    public void updatePersonne(PersonneEntity personne) {
        em.merge(personne);
    }
}
