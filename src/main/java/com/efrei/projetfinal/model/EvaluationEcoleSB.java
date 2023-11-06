package com.efrei.projetfinal.model;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class EvaluationEcoleSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    @PersistenceContext
    private EntityManager entityManager;

    public EvaluationEcoleEntity getEntrepriseByIdApprenti(int idApprenti) {
        TypedQuery<EvaluationEcoleEntity> query = em.createNamedQuery("EvaluationEcoleEntity.findByIdApprenti", EvaluationEcoleEntity.class);
        query.setParameter("idApprenti", idApprenti);
        return query.getSingleResult();
    }



}

