package com.efrei.projetfinal.model;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class TuteurSB {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @PersistenceContext
    private EntityManager entityManager;
    @EJB
    private UtilisateurSB utilisateurSB;

    public void createTuteur(String nom, String prenom, String adresseElectronique, String telephone, String nomUtilisateur, String motDePasse) {
        // Create an utilisateur and get the UtilisateurEntity instance
        UtilisateurEntity createdUtilisateur = utilisateurSB.createUtilisateur(nom, prenom, adresseElectronique, telephone, nomUtilisateur, motDePasse);

        // Create a new Tuteur
        TuteurEntity newTuteur = new TuteurEntity();
        newTuteur.setUtilisateur(createdUtilisateur);

        em.persist(newTuteur);
        em.flush();
    }

    public List<TuteurEntity> getAllTuteurs() {
        TypedQuery<TuteurEntity> query = em.createNamedQuery("TuteurEntity.findAll", TuteurEntity.class);
        return query.getResultList();
    }

    public TuteurEntity getTuteur(int idTuteur) {
        TypedQuery<TuteurEntity> query = em.createNamedQuery("TuteurEntity.findById", TuteurEntity.class);
        query.setParameter("idTuteur", idTuteur);
        return query.getSingleResult();
    }

    public void updateTuteur(TuteurEntity tuteur) {
        if (tuteur != null && tuteur.getIdTuteur() > 0) {
            Query query = em.createNamedQuery("TuteurEntity.updateUtilisateur");
            query.setParameter("utilisateur", tuteur.getUtilisateur());
            query.setParameter("idTuteur", tuteur.getIdTuteur());
            query.executeUpdate();
        }
    }

    public List<ApprentiEntity> getAllTuteurApprentis(int idTuteur) {
        TypedQuery<ApprentiEntity> query = em.createNamedQuery("TuteurEntity.findAllApprentisByTuteurId", ApprentiEntity.class);
        query.setParameter("idTuteur", idTuteur);
        return query.getResultList();
    }
}
