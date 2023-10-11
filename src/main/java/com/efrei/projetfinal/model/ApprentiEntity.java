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
    /*
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
    */
    @OneToOne
    @JoinColumn(name = "id_tuteur")
    private TuteurEntity tuteur;
    @OneToOne
    @JoinColumn(name = "id_maitre_apprentissage")
    private MaitreApprentissageEntity maitreApprentissage;
    @OneToOne
    @JoinColumn(name = "id_entreprise")
    private EntrepriseEntity entreprise;
    @OneToOne
    @JoinColumn(name = "id_utilisateur")
    private UtilisateurEntity utilisateur;

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

    public TuteurEntity getTuteur() {
        return tuteur;
    }

    public void setTuteur(TuteurEntity tuteur) {
        this.tuteur = tuteur;
    }

    public MaitreApprentissageEntity getMaitreApprentissage() {
        return maitreApprentissage;
    }

    public void setIdMaitreApprentissage(MaitreApprentissageEntity maitreApprentissage) {
        this.maitreApprentissage = maitreApprentissage;
    }

    public EntrepriseEntity getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(EntrepriseEntity idEntreprise) {
        this.entreprise = idEntreprise;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public void setIdUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprentiEntity that = (ApprentiEntity) o;

        if (idApprenti != that.idApprenti) return false;
        if (utilisateur != that.utilisateur) return false;
        if (anneeAcademique != null ? !anneeAcademique.equals(that.anneeAcademique) : that.anneeAcademique != null)
            return false;
        if (majeure != null ? !majeure.equals(that.majeure) : that.majeure != null) return false;
        if (tuteur != null ? !tuteur.equals(that.tuteur) : that.tuteur != null) return false;
        if (maitreApprentissage != null ? !maitreApprentissage.equals(that.maitreApprentissage) : that.maitreApprentissage != null)
            return false;
        if (entreprise != null ? !entreprise.equals(that.entreprise) : that.entreprise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idApprenti;
        result = 31 * result + (anneeAcademique != null ? anneeAcademique.hashCode() : 0);
        result = 31 * result + (majeure != null ? majeure.hashCode() : 0);
        result = 31 * result + (tuteur != null ? tuteur.hashCode() : 0);
        result = 31 * result + (maitreApprentissage != null ? maitreApprentissage.hashCode() : 0);
        result = 31 * result + (entreprise != null ? entreprise.hashCode() : 0);
        result = 31 * result + (utilisateur != null ? utilisateur.hashCode() : 0);
        return result;
    }
}
