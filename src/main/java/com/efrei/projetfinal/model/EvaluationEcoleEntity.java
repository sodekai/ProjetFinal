package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluation_ecole", schema = "tutorat", catalog = "")
@NamedQueries({
        @NamedQuery(
                name = "EvaluationEcoleEntity.findAll",
                query = "SELECT e FROM EvaluationEcoleEntity e"
        ),
        @NamedQuery(
                name = "EvaluationEcoleEntity.findByIdApprenti",
                query = "SELECT e FROM EvaluationEcoleEntity e WHERE e.apprenti.idApprenti = :idApprenti"
        )
})
public class EvaluationEcoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_evaluation_ecole", nullable = false)
    private int idEvaluationEcole;

    @OneToOne
    @JoinColumn(name = "id_apprenti")
    private ApprentiEntity apprenti;
    @OneToOne
    @JoinColumn(name = "Id_soutenance")
    private SoutenanceEntity soutenance;
    @OneToOne
    @JoinColumn(name = "Id_memoire")
    private MemoireEntity memoire;

    public int getIdEvaluationEcole() {
        return idEvaluationEcole;
    }

    public void setIdEvaluationEcole(int idEvaluationEcole) {
        this.idEvaluationEcole = idEvaluationEcole;
    }

    public ApprentiEntity getApprenti() {
        return apprenti;
    }

    public void setApprenti(ApprentiEntity apprenti) {
        this.apprenti = apprenti;
    }

    public SoutenanceEntity getSoutenance() {
        return soutenance;
    }

    public void setSoutenance(SoutenanceEntity soutenance) {
        this.soutenance = soutenance;
    }

    public MemoireEntity getMemoire() {
        return memoire;
    }

    public void setMemoire(MemoireEntity memoire) {
        this.memoire = memoire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationEcoleEntity that = (EvaluationEcoleEntity) o;

        if (idEvaluationEcole != that.idEvaluationEcole) return false;
        if (apprenti != that.apprenti) return false;
        if (soutenance != null ? !soutenance.equals(that.soutenance) : that.soutenance != null) return false;
        if (memoire != null ? !memoire.equals(that.memoire) : that.memoire != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvaluationEcole;
        result = 31 * result + (apprenti != null ? apprenti.hashCode() : 0);
        result = 31 * result + (soutenance != null ? soutenance.hashCode() : 0);
        result = 31 * result + (memoire != null ? memoire.hashCode() : 0);
        return result;
    }
}
