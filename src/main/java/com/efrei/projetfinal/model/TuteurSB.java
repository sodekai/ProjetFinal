package com.efrei.projetfinal.model;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class TuteurSB {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @EJB
    private UtilisateurSB utilisateurSB;

    public List<TuteurEntity> getAllTuteurs() {
        Query q = em.createQuery("select t from TuteurEntity t");
        return q.getResultList();
    }

    public TuteurEntity getTuteur(int idTuteur) {
        TuteurEntity tuteurEntity = (TuteurEntity) em.createQuery(
                        "select t from TuteurEntity t where t.idTuteur = :idTuteur")
                .setParameter("idTuteur", idTuteur)
                .getSingleResult();
        return tuteurEntity;
    }

    public void createTuteur(String nom, String prenom, String adresseElectronique, String telephone, String nomUtilisateur, String motDePasse) {
        // Create an utilisateur and get the UtilisateurEntity instance
        UtilisateurEntity createdUtilisateur = utilisateurSB.createUtilisateur(nom, prenom, adresseElectronique, telephone, nomUtilisateur, motDePasse);

        // Create a new Tuteur
        TuteurEntity newTuteur = new TuteurEntity();
        newTuteur.setUtilisateur(createdUtilisateur);

        em.persist(newTuteur);
        em.flush();
    }


}
