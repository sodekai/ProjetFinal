package com.efrei.projetfinal.model;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

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

    public List<ApprentiEntity> getApprentiByTuteur (int idTuteur){
        TypedQuery<ApprentiEntity> query = em.createNamedQuery("ApprentiEntity.findAllApprentisByTuteur", ApprentiEntity.class);
        query.setParameter("idTuteur", idTuteur);
        return query.getResultList();
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

    public void modifierApprenti(ApprentiEntity apprentiAModifier) {
        em.getTransaction().begin();
        em.merge(apprentiAModifier);
        em.getTransaction().commit();
        em.clear();
    }


    public List<VisiteEntity> getAllApprentiVisites(int idApprenti) {
        TypedQuery<VisiteEntity> query = em.createNamedQuery("ApprentiEntity.findAllVisitesByApprentiId", VisiteEntity.class);
        query.setParameter("idApprenti", idApprenti);
        return query.getResultList();
    }


    public List<FeedbackApprentiEntity> getAllApprentiFeedbacks(int idApprenti) {
        TypedQuery<FeedbackApprentiEntity> query = em.createNamedQuery("ApprentiEntity.findAllFeedbacksByApprentiId", FeedbackApprentiEntity.class);
        query.setParameter("idApprenti", idApprenti);
        return query.getResultList();
    }

    public List<EvaluationEcoleEntity> getAllApprentiEvaluationsEcole(int idApprenti) {
        TypedQuery<EvaluationEcoleEntity> query = em.createNamedQuery("ApprentiEntity.findAllEvaluationsEcoleByApprentiId", EvaluationEcoleEntity.class);
        query.setParameter("idApprenti", idApprenti);
        return query.getResultList();
    }

    public List<ApprentiEntity> getApprentisByWord(String field) {
        em.clear();
        TypedQuery<ApprentiEntity> queryByNom = em.createNamedQuery("ApprentiEntity.findAllApprentisByNom", ApprentiEntity.class);
        queryByNom.setParameter("nom", field);
        List<ApprentiEntity> resultByNom = queryByNom.getResultList();
        if(resultByNom.size() > 0){
            return resultByNom;
        }

        em.clear();
        TypedQuery<ApprentiEntity> queryByEntreprise = em.createNamedQuery("ApprentiEntity.findAllApprentisByEntreprise", ApprentiEntity.class);
        queryByEntreprise.setParameter("raisonSociale", field);
        List<ApprentiEntity> resultByEntreprise = queryByEntreprise.getResultList();
        if(resultByEntreprise.size() > 0){
            return resultByEntreprise;
        }

        em.clear();
        TypedQuery<ApprentiEntity> queryByMotCleMission = em.createNamedQuery("ApprentiEntity.findAllApprentisByMotCleMission", ApprentiEntity.class);
        queryByMotCleMission.setParameter("motCleMission", field);
        List<ApprentiEntity> resultByMotCleMission = queryByMotCleMission.getResultList();
        if(resultByMotCleMission.size() > 0){
            return resultByEntreprise;
        }

        em.clear();
        TypedQuery<ApprentiEntity> queryByAnneeAcademique = em.createNamedQuery("ApprentiEntity.findAllApprentisByAnneeAcademique", ApprentiEntity.class);
        queryByAnneeAcademique.setParameter("anneeAcademique", field);
        List<ApprentiEntity> resultByAnneeAcademique = queryByAnneeAcademique.getResultList();
        if(resultByAnneeAcademique.size() > 0){
            return resultByAnneeAcademique;
        }
        return null;
    }
}
