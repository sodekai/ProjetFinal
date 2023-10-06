package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apprenti", schema = "tutorat", catalog = "")
public class ApprentiEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_apprenti", nullable = false)
    private int idApprenti;
    @Basic
    @Column(name = "annee_academique", nullable = true, length = 150)
    private String anneeAcademique;
    @Basic
    @Column(name = "majeure", nullable = true, length = 150)
    private String majeure;
    @Basic
    @Column(name = "id_tuteur", nullable = true)
    private Integer idTuteur;
    @Basic
    @Column(name = "id_maitre_apprentissage", nullable = true)
    private Integer idMaitreApprentissage;
    @Basic
    @Column(name = "id_entreprise", nullable = true)
    private Integer idEntreprise;
    @Basic
    @Column(name = "id_utilisateur", nullable = false)
    private int idUtilisateur;

    public int getIdApprenti() {
        return idApprenti;
    }

    public void setIdApprenti(int idApprenti) {
        this.idApprenti = idApprenti;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public String getMajeure() {
        return majeure;
    }

    public void setMajeure(String majeure) {
        this.majeure = majeure;
    }

    public Integer getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(Integer idTuteur) {
        this.idTuteur = idTuteur;
    }

    public Integer getIdMaitreApprentissage() {
        return idMaitreApprentissage;
    }

    public void setIdMaitreApprentissage(Integer idMaitreApprentissage) {
        this.idMaitreApprentissage = idMaitreApprentissage;
    }

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprentiEntity that = (ApprentiEntity) o;

        if (idApprenti != that.idApprenti) return false;
        if (idUtilisateur != that.idUtilisateur) return false;
        if (anneeAcademique != null ? !anneeAcademique.equals(that.anneeAcademique) : that.anneeAcademique != null)
            return false;
        if (majeure != null ? !majeure.equals(that.majeure) : that.majeure != null) return false;
        if (idTuteur != null ? !idTuteur.equals(that.idTuteur) : that.idTuteur != null) return false;
        if (idMaitreApprentissage != null ? !idMaitreApprentissage.equals(that.idMaitreApprentissage) : that.idMaitreApprentissage != null)
            return false;
        if (idEntreprise != null ? !idEntreprise.equals(that.idEntreprise) : that.idEntreprise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idApprenti;
        result = 31 * result + (anneeAcademique != null ? anneeAcademique.hashCode() : 0);
        result = 31 * result + (majeure != null ? majeure.hashCode() : 0);
        result = 31 * result + (idTuteur != null ? idTuteur.hashCode() : 0);
        result = 31 * result + (idMaitreApprentissage != null ? idMaitreApprentissage.hashCode() : 0);
        result = 31 * result + (idEntreprise != null ? idEntreprise.hashCode() : 0);
        result = 31 * result + idUtilisateur;
        return result;
    }
}
