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

    public void createUtilisateur(String nom, String prenom, String adresseElectronique, String telephone, String nomUtilisateur, String motDePasse) {
        personneSB.createPersonne(nom, prenom, adresseElectronique, telephone);
        Query qCreateUtilisateur = em.createNativeQuery(
                "insert into UtilisateurEntity (nomUtilisateur, motDePasse) VALUES (:nomUtilisateur, :motDePasse)");
        qCreateUtilisateur.setParameter("nomUtilisateur", nomUtilisateur);
        qCreateUtilisateur.setParameter("motDePasse", motDePasse);
    }

    public List<UtilisateurEntity> get_all_utilisateurs(){
        Query q = em.createQuery("select u from UtilisateurEntity u");
        return q.getResultList();
    }


}
