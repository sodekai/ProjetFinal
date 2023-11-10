package com.efrei.projetfinal.model;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class EntrepriseSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @PersistenceContext
    private EntityManager entityManager;
    @EJB
    private UtilisateurSB utilisateurSB;
    public EntrepriseEntity createEntreprise(String raisonSociale, String adresse, String informationsUtiles) {
        em.getTransaction().begin();
        EntrepriseEntity newEntreprise = new EntrepriseEntity();
        newEntreprise.setRaisonSociale(raisonSociale);
        newEntreprise.setAdresse(adresse);
        newEntreprise.setInformationsUtiles(informationsUtiles);
        em.persist(newEntreprise);
        em.flush();
        em.getTransaction().commit();
        return newEntreprise;
    }

    public EntrepriseEntity getEntrepriseById(int idEntreprise) {
        TypedQuery<EntrepriseEntity> query = em.createNamedQuery("EntrepriseEntity.findById", EntrepriseEntity.class);
        query.setParameter("idEntreprise", idEntreprise);
        return query.getSingleResult();
    }

    public List<EntrepriseEntity> getAllEntreprises() {
        Query q = em.createNamedQuery("EntrepriseEntity.findAll");
        return q.getResultList();
    }

    public void updateEntreprise(EntrepriseEntity entreprise) {
        em.getTransaction().begin();
        em.merge(entreprise);
        em.getTransaction().commit();
        em.clear();
    }

    public void deleteEntreprise(int idEntreprise) {
        Query query = em.createNamedQuery("EntrepriseEntity.delete");
        query.setParameter("idEntreprise", idEntreprise);
        query.executeUpdate();
    }


}

