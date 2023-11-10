package com.efrei.projetfinal.model;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class MaitreApprentissageSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @EJB
    private PersonneSB personneSB;

    @EJB
    private EntrepriseSB entrepriseSB;

    public MaitreApprentissageEntity createMaitreApprentissage(String nom, String prenom, String adresseElectronique, String telephone, String remarque, String poste, int idEntreprise) {

        PersonneEntity createdPersonne = personneSB.createPersonne(nom, prenom, adresseElectronique, telephone);
        EntrepriseEntity associatedEntreprise = entrepriseSB.getEntrepriseById(idEntreprise);
        MaitreApprentissageEntity newMaitre = new MaitreApprentissageEntity();
        newMaitre.setRemarque(remarque);
        newMaitre.setPoste(poste);
        newMaitre.setPersonne(createdPersonne);
        newMaitre.setEntreprise(associatedEntreprise);
        em.getTransaction().begin();
        em.persist(newMaitre);
        em.flush();
        em.getTransaction().commit();

        return newMaitre;
    }

    public List<MaitreApprentissageEntity> getAllMaitres() {
        Query q = em.createNamedQuery("MaitreApprentissageEntity.findAll");
        return q.getResultList();
    }

    public MaitreApprentissageEntity getMaitreById(int idMaitre) {
        TypedQuery<MaitreApprentissageEntity> query = em.createNamedQuery("MaitreApprentissageEntity.findById", MaitreApprentissageEntity.class);
        query.setParameter("idMaitreApprentissage", idMaitre);
        return query.getSingleResult();
    }

    public void updateMaitre(MaitreApprentissageEntity maitre) {
        em.getTransaction().begin();
        em.merge(maitre);
        em.getTransaction().commit();
        em.clear();
    }


}

