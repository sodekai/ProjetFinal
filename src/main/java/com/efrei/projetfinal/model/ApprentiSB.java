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

        return apprentiEntity;
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

}
