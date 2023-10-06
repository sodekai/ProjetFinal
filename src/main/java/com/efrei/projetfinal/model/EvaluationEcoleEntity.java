package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluation_ecole", schema = "tutorat", catalog = "")
public class EvaluationEcoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_evaluation_ecole", nullable = false)
    private int idEvaluationEcole;
    @Basic
    @Column(name = "id_apprenti", nullable = false)
    private int idApprenti;
    @Basic
    @Column(name = "Id_soutenance", nullable = true)
    private Integer idSoutenance;
    @Basic
    @Column(name = "Id_memoire", nullable = true)
    private Integer idMemoire;

    public int getIdEvaluationEcole() {
        return idEvaluationEcole;
    }

    public void setIdEvaluationEcole(int idEvaluationEcole) {
        this.idEvaluationEcole = idEvaluationEcole;
    }

    public int getIdApprenti() {
        return idApprenti;
    }

    public void setIdApprenti(int idApprenti) {
        this.idApprenti = idApprenti;
    }

    public Integer getIdSoutenance() {
        return idSoutenance;
    }

    public void setIdSoutenance(Integer idSoutenance) {
        this.idSoutenance = idSoutenance;
    }

    public Integer getIdMemoire() {
        return idMemoire;
    }

    public void setIdMemoire(Integer idMemoire) {
        this.idMemoire = idMemoire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationEcoleEntity that = (EvaluationEcoleEntity) o;

        if (idEvaluationEcole != that.idEvaluationEcole) return false;
        if (idApprenti != that.idApprenti) return false;
        if (idSoutenance != null ? !idSoutenance.equals(that.idSoutenance) : that.idSoutenance != null) return false;
        if (idMemoire != null ? !idMemoire.equals(that.idMemoire) : that.idMemoire != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvaluationEcole;
        result = 31 * result + idApprenti;
        result = 31 * result + (idSoutenance != null ? idSoutenance.hashCode() : 0);
        result = 31 * result + (idMemoire != null ? idMemoire.hashCode() : 0);
        return result;
    }
}
