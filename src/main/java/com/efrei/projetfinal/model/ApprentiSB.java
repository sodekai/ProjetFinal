package com.efrei.projetfinal.model;

import com.efrei.projetfinal.*;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ApprentiSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @EJB
    private UtilisateurSB utilisateurSB;


    public List<ApprentiEntity> get_all_apprentis(){
        Query q = em.createQuery("select a from ApprentiEntity a");
        return q.getResultList();
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
