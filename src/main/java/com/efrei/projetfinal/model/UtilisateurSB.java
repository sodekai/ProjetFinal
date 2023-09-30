package com.efrei.projetfinal.model;

import com.efrei.projetfinal.Personne;
import com.efrei.projetfinal.Utilisateur;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class UtilisateurSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @PersistenceContext
    private EntityManager entityManager;

    public Utilisateur createUtilisateur(Personne personne, String nomUtilisateur, String motDePasse) {
        Utilisateur utilisateur = new Utilisateur(
                personne.getNom(), personne.getPrenom(), personne.getAdresseElectronique(), personne.getTelephone(),
                nomUtilisateur, motDePasse);
        entityManager.persist(utilisateur);
        return utilisateur;
    }

    public List<UtilisateurEntity> get_all_utilisateurs(){
        Query q = em.createQuery("select u from UtilisateurEntity u");
        return q.getResultList();
    }


}
