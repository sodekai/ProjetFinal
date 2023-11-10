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
    public List<ApprentiEntity> getAllApprentibyTuteurUserId(int idTuteurUser) {
        TypedQuery<ApprentiEntity> query = em.createNamedQuery("TuteurEntity.findAllApprentisByTuteurUserId", ApprentiEntity.class);
        query.setParameter("idTuteurUser", idTuteurUser);
        return query.getResultList();
    }
    public void updateTuteur(TuteurEntity tuteur) {
        em.getTransaction().begin();
        em.merge(tuteur);
        em.getTransaction().commit();
        em.clear();
    }

    public List<ApprentiEntity> getAllTuteurApprentis(int idTuteur) {
        TypedQuery<ApprentiEntity> query = em.createNamedQuery("TuteurEntity.findAllApprentisByTuteurId", ApprentiEntity.class);
        query.setParameter("idTuteur", idTuteur);
        return query.getResultList();
    }

    public TuteurEntity getTuteurUserId(int idUser) {
        TypedQuery<TuteurEntity> query = em.createNamedQuery("TuteurEntity.getTuteurUserId", TuteurEntity.class);
        query.setParameter("idUser", idUser);
        return query.getSingleResult();
    }
}
