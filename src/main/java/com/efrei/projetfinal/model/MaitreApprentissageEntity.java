package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "maitre_apprentissage", schema = "tutorat", catalog = "")
public class MaitreApprentissageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_maitre_apprentissage", nullable = false)
    private int idMaitreApprentissage;
    @Basic
    @Column(name = "remarque", nullable = true, length = 150)
    private String remarque;
    @Basic
    @Column(name = "poste", nullable = true, length = 150)
    private String poste;
    @Basic
    @Column(name = "id_entreprise", nullable = true)
    private Integer idEntreprise;
    @Basic
    @Column(name = "id_personne", nullable = false)
    private int idPersonne;

    public int getIdMaitreApprentissage() {
        return idMaitreApprentissage;
    }

    public void setIdMaitreApprentissage(int idMaitreApprentissage) {
        this.idMaitreApprentissage = idMaitreApprentissage;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaitreApprentissageEntity that = (MaitreApprentissageEntity) o;

        if (idMaitreApprentissage != that.idMaitreApprentissage) return false;
        if (idPersonne != that.idPersonne) return false;
        if (remarque != null ? !remarque.equals(that.remarque) : that.remarque != null) return false;
        if (poste != null ? !poste.equals(that.poste) : that.poste != null) return false;
        if (idEntreprise != null ? !idEntreprise.equals(that.idEntreprise) : that.idEntreprise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMaitreApprentissage;
        result = 31 * result + (remarque != null ? remarque.hashCode() : 0);
        result = 31 * result + (poste != null ? poste.hashCode() : 0);
        result = 31 * result + (idEntreprise != null ? idEntreprise.hashCode() : 0);
        result = 31 * result + idPersonne;
        return result;
    }
}
