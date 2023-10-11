package com.efrei.projetfinal.model;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Map;

@Stateless
public class ApprentiSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @EJB
    private UtilisateurSB utilisateurSB;

    public List<ApprentiEntity> getAllApprentis(){
        Query q = em.createQuery("select a from ApprentiEntity a");
        return q.getResultList();
    }

    public ApprentiEntity getApprenti(int idApprenti){
        ApprentiEntity apprentiEntity = (ApprentiEntity) em.createQuery(
                    "select a from ApprentiEntity a where a.idApprenti=:idApprenti")
                .setParameter("idApprenti", idApprenti)
                .getSingleResult();
        /*UtilisateurEntity utilisateurEntity = (UtilisateurEntity) em.createQuery(
                        "select u from UtilisateurEntity u where u.idUtilisateur=:idUtilisateur")
                .setParameter("idUtilisateur", apprentiEntity.getIdUtilisateur())
                .getSingleResult();
        PersonneEntity personneEntity = (PersonneEntity) em.createQuery(
                        "select p from PersonneEntity p where p.idPersonne=:idPersonne")
                .setParameter("idPersonne", utilisateurEntity.getIdPersonne())
                .getSingleResult();
        EntrepriseEntity entrepriseEntity = (EntrepriseEntity) em.createQuery(
                        "select p from PersonneEntity p where p.idPersonne=:idPersonne")
                .setParameter("idPersonne", apprentiEntity.getIdEntreprise())
                .getSingleResult();

        Entreprise entreprise = new Entreprise(apprentiEntity.getIdEntreprise(), entrepriseEntity.getRaisonSociale(), entrepriseEntity.getAdresse(), entrepriseEntity.getInformationsUtiles());

        Apprenti apprenti = new Apprenti(
                personneEntity.getNom(), personneEntity.getPrenom(), personneEntity.getAdresseElectronique(),
                personneEntity.getTelephone(),
                utilisateurEntity.getNomUtilisateur(), utilisateurEntity.getMotDePasse(),
                apprentiEntity.getAnneeAcademique(), apprentiEntity.getMajeure(),
                entreprise);

        return apprenti.getInfos();*/
        return apprentiEntity;
    }

    public void createApprenti(String nom, String prenom, String adresseElectronique, String telephone, String nomUtilisateur, String motDePasse, String anneeAcademique, String majeure, int idEntreprise){
        /*EvaluationEcole evaluation;
        if(Integer.getInteger(String.valueOf(idEvaluation)) != null){
            evaluation = new EvaluationEcole();
        } else {
            evaluation = null;
        }
        FeedbackApprenti feedback;
        if(Integer.getInteger(String.valueOf(idFeedback)) != null){
            feedback = new FeedbackApprenti();
        } else {
            feedback = null;
        }
        Entreprise entreprise;
        if(Integer.getInteger(String.valueOf(idEntreprise)) != null){
            entreprise = new Entreprise();
        } else {
            entreprise = null;
        }

        Apprenti apprenti = new Apprenti(nom, prenom, adresseElectronique, telephone, nomUtilisateur, motDePasse, anneeAcademique, majeure, entreprise);

        entityManager.getTransaction().begin();
        entityManager.persist(apprenti);
        entityManager.getTransaction().commit();

        return apprenti;*/

        utilisateurSB.createUtilisateur(nom, prenom, adresseElectronique, telephone, nomUtilisateur, motDePasse);

        Query qCreateApprenti = em.createNativeQuery(
                "insert into ApprentiEntity (anneeAcademique, majeure, idEntreprise) VALUES (:anneeAcademique, :majeure, :idEntreprise)")
                .setParameter("nomUtilisateur", nomUtilisateur)
                .setParameter("motDePasse", motDePasse);


    }

}
