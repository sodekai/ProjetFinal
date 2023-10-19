package com.efrei.projetfinal.model;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class PersonneSB {

    @PersistenceContext
    private EntityManager em;

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
        Query query = em.createNamedQuery("PersonneEntity.updateDetailsById");
        query.setParameter("idPersonne", personne.getIdPersonne());
        query.setParameter("nom", personne.getNom());
        query.setParameter("prenom", personne.getPrenom());
        query.setParameter("adresseElectronique", personne.getAdresseElectronique());
        query.setParameter("telephone", personne.getTelephone());

        query.executeUpdate();
    }
}
