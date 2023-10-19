package com.efrei.projetfinal.model;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class MaitreApprentissageSB {
    @PersistenceContext
    private EntityManager em;

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
        em.persist(newMaitre);
        em.flush();

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
        Query query = em.createNamedQuery("MaitreApprentissageEntity.update");
        query.setParameter("remarque", maitre.getRemarque());
        query.setParameter("poste", maitre.getPoste());
        query.setParameter("entreprise", maitre.getEntreprise());
        query.setParameter("personne", maitre.getPersonne());
        query.setParameter("idMaitreApprentissage", maitre.getIdMaitreApprentissage());
        query.executeUpdate();
    }


}

