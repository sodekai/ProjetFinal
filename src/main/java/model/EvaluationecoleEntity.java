package model;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluationecole", schema = "tutorat", catalog = "")
public class EvaluationecoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_evaluation", nullable = false)
    private int idEvaluation;
    @Basic
    @Column(name = "ID_Soutenance", nullable = true)
    private Integer idSoutenance;
    @Basic
    @Column(name = "ID_memoire", nullable = true)
    private Integer idMemoire;

    public int getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
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

        EvaluationecoleEntity that = (EvaluationecoleEntity) o;

        if (idEvaluation != that.idEvaluation) return false;
        if (idSoutenance != null ? !idSoutenance.equals(that.idSoutenance) : that.idSoutenance != null) return false;
        if (idMemoire != null ? !idMemoire.equals(that.idMemoire) : that.idMemoire != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvaluation;
        result = 31 * result + (idSoutenance != null ? idSoutenance.hashCode() : 0);
        result = 31 * result + (idMemoire != null ? idMemoire.hashCode() : 0);
        return result;
    }
}
