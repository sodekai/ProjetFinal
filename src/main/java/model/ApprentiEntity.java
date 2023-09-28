package model;

import jakarta.persistence.*;

@Entity
@Table(name = "apprenti", schema = "tutorat", catalog = "")
public class ApprentiEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Utilisateur", nullable = false)
    private int idUtilisateur;
    @Basic
    @Column(name = "AnneeAcademique", nullable = true, length = 150)
    private String anneeAcademique;
    @Basic
    @Column(name = "Majeure", nullable = true, length = 150)
    private String majeure;
    @Basic
    @Column(name = "ID_FeedBack", nullable = true)
    private Integer idFeedBack;
    @Basic
    @Column(name = "ID_evaluation", nullable = true)
    private Integer idEvaluation;
    @Basic
    @Column(name = "ID_entreprise", nullable = true)
    private Integer idEntreprise;

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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

    public Integer getIdFeedBack() {
        return idFeedBack;
    }

    public void setIdFeedBack(Integer idFeedBack) {
        this.idFeedBack = idFeedBack;
    }

    public Integer getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Integer idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprentiEntity that = (ApprentiEntity) o;

        if (idUtilisateur != that.idUtilisateur) return false;
        if (anneeAcademique != null ? !anneeAcademique.equals(that.anneeAcademique) : that.anneeAcademique != null)
            return false;
        if (majeure != null ? !majeure.equals(that.majeure) : that.majeure != null) return false;
        if (idFeedBack != null ? !idFeedBack.equals(that.idFeedBack) : that.idFeedBack != null) return false;
        if (idEvaluation != null ? !idEvaluation.equals(that.idEvaluation) : that.idEvaluation != null) return false;
        if (idEntreprise != null ? !idEntreprise.equals(that.idEntreprise) : that.idEntreprise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUtilisateur;
        result = 31 * result + (anneeAcademique != null ? anneeAcademique.hashCode() : 0);
        result = 31 * result + (majeure != null ? majeure.hashCode() : 0);
        result = 31 * result + (idFeedBack != null ? idFeedBack.hashCode() : 0);
        result = 31 * result + (idEvaluation != null ? idEvaluation.hashCode() : 0);
        result = 31 * result + (idEntreprise != null ? idEntreprise.hashCode() : 0);
        return result;
    }
}
