package com.efrei.projetfinal.model;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Stateless
public class VisiteSB {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @PersistenceContext
    private EntityManager entityManager;

    public VisiteEntity createVisite(Date dateVisite, String format, String compteRendu, int idApprenti) {
        VisiteEntity newVisite = new VisiteEntity();
        newVisite.setDateVisite(dateVisite);
        newVisite.setFormat(format);
        newVisite.setCompteRendu(compteRendu);
        newVisite.setIdApprenti(idApprenti);
        em.persist(newVisite);
        return newVisite;
    }

    public VisiteEntity getVisiteById(int idVisite) {
        TypedQuery<VisiteEntity> query = em.createNamedQuery("VisiteEntity.findById", VisiteEntity.class);
        query.setParameter("idVisite", idVisite);
        return query.getSingleResult();
    }

    public List<VisiteEntity> getAllVisites() {
        TypedQuery<VisiteEntity> query = em.createNamedQuery("VisiteEntity.findAll", VisiteEntity.class);
        return query.getResultList();
    }

    public void updateVisite(VisiteEntity visite) {
        Query query = em.createNamedQuery("VisiteEntity.update");
        query.setParameter("idVisite", visite.getIdVisite());
        query.setParameter("dateVisite", visite.getDateVisite());
        query.setParameter("format", visite.getFormat());
        query.setParameter("compteRendu", visite.getCompteRendu());
        query.setParameter("idApprenti", visite.getIdApprenti());
        query.executeUpdate();
    }

    public void deleteVisite(int idVisite) {
        Query query = em.createNamedQuery("VisiteEntity.delete");
        query.setParameter("idVisite", idVisite);
        query.executeUpdate();
    }

}
