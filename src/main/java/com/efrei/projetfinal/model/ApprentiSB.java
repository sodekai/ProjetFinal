package com.efrei.projetfinal.model;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Stateless
public class ApprentiSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @PersistenceContext
    private EntityManager entityManager;
    @EJB
    private UtilisateurSB utilisateurSB;

    public List<ApprentiEntity> getAllApprentis(){
        TypedQuery<ApprentiEntity> query = em.createNamedQuery("ApprentiEntity.findAll", ApprentiEntity.class);
        return query.getResultList();
    }

    public ApprentiEntity getApprenti(int idApprenti){
        TypedQuery<ApprentiEntity> query = em.createNamedQuery("ApprentiEntity.findById", ApprentiEntity.class);
        query.setParameter("idApprenti", idApprenti);
        return query.getSingleResult();
    }

    public ApprentiEntity getApprentiByIdUtilisateur(int idUtilisateur){
        TypedQuery<ApprentiEntity> query = em.createNamedQuery("ApprentiEntity.findByUtilisateurId", ApprentiEntity.class);
        query.setParameter("idUtilisateur", idUtilisateur);
        return query.getSingleResult();
    }

    public void createApprenti(String nom, String prenom, String adresseElectronique, String telephone, String nomUtilisateur, String motDePasse, String anneeAcademique, String majeure) {
        UtilisateurEntity createdUtilisateur = utilisateurSB.createUtilisateur(nom, prenom, adresseElectronique, telephone, nomUtilisateur, motDePasse);

        ApprentiEntity newApprenti = new ApprentiEntity();
        newApprenti.setAnneeAcademique(anneeAcademique);
        newApprenti.setMajeure(majeure);
        newApprenti.setUtilisateur(createdUtilisateur);

        em.persist(newApprenti);
        em.flush();
    }

    public void updateApprenti(ApprentiEntity apprenti) {
        Query query = em.createNamedQuery("ApprentiEntity.update");
        query.setParameter("anneeAcademique", apprenti.getAnneeAcademique());
        query.setParameter("majeure", apprenti.getMajeure());
        query.setParameter("utilisateur", apprenti.getUtilisateur());
        query.setParameter("idApprenti", apprenti.getIdApprenti());
        query.executeUpdate();
    }


    public List<VisiteEntity> getAllApprentiVisites(int idApprenti) {
        TypedQuery<VisiteEntity> query = em.createNamedQuery("ApprentiEntity.findAllVisitesByApprentiId", VisiteEntity.class);
        query.setParameter("idApprenti", idApprenti);
        return query.getResultList();
    }


}
