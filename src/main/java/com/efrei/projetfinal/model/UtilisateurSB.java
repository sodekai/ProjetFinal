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


    public List<UtilisateurEntity> get_all_utilisateurs(){
        Query q = em.createQuery("select u from UtilisateurEntity u");
        return q.getResultList();
    }

    public int getIdByUserName(String nomUtilisateur) {
        Query q = em.createQuery("select u.idUtilisateur from UtilisateurEntity u where u.nomUtilisateur = :nomUtilisateur")
                .setParameter("nomUtilisateur", nomUtilisateur);
        return (int) q.getSingleResult();
    }
}

