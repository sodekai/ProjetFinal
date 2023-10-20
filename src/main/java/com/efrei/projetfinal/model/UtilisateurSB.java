package com.efrei.projetfinal.model;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class UtilisateurSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @PersistenceContext
    private EntityManager entityManager;
    @EJB
    private PersonneSB personneSB;

    public UtilisateurEntity createUtilisateur(String nom, String prenom, String adresseElectronique, String telephone, String nomUtilisateur, String motDePasse) {
        PersonneEntity createdPersonne = personneSB.createPersonne(nom, prenom, adresseElectronique, telephone);

        UtilisateurEntity newUser = new UtilisateurEntity();
        newUser.setNomUtilisateur(nomUtilisateur);
        newUser.setMotDePasse(motDePasse);
        newUser.setPersonne(createdPersonne);
        em.persist(newUser);
        em.flush();

        return newUser;
    }

    public List<UtilisateurEntity> get_all_utilisateurs() {
        TypedQuery<UtilisateurEntity> query = em.createNamedQuery("UtilisateurEntity.findAll", UtilisateurEntity.class);
        return query.getResultList();
    }

    public UtilisateurEntity getUtilisateurByIdentifiants(String nomUtilisateur, String motDePasse) {
        TypedQuery<UtilisateurEntity> query = em.createNamedQuery("UtilisateurEntity.findByIdentifiers", UtilisateurEntity.class);
        query.setParameter("nomUtilisateur", nomUtilisateur);
        query.setParameter("motDePasse", motDePasse);
        return query.getSingleResult();
    }

    public UtilisateurEntity getUtilisateurById(int idUtilisateur) {
        TypedQuery<UtilisateurEntity> query = em.createNamedQuery("UtilisateurEntity.findById", UtilisateurEntity.class);
        query.setParameter("idUtilisateur", idUtilisateur);
        return query.getSingleResult();
    }

    public void updateUtilisateur(UtilisateurEntity utilisateur) {
        Query query = em.createNamedQuery("UtilisateurEntity.updateDetailsById");
        query.setParameter("idUtilisateur", utilisateur.getIdUtilisateur());
        query.setParameter("nomUtilisateur", utilisateur.getNomUtilisateur());
        query.setParameter("motDePasse", utilisateur.getMotDePasse());

        query.executeUpdate();
    }
}

