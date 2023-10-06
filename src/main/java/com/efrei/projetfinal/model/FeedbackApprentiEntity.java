package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback_apprenti", schema = "tutorat", catalog = "")
public class FeedbackApprentiEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_feedback_apprenti", nullable = false)
    private int idFeedbackApprenti;
    @Basic
    @Column(name = "avis", nullable = true, length = 150)
    private String avis;
    @Basic
    @Column(name = "id_apprenti", nullable = false)
    private int idApprenti;

    public int getIdFeedbackApprenti() {
        return idFeedbackApprenti;
    }

    public void setIdFeedbackApprenti(int idFeedbackApprenti) {
        this.idFeedbackApprenti = idFeedbackApprenti;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public int getIdApprenti() {
        return idApprenti;
    }

    public void setIdApprenti(int idApprenti) {
        this.idApprenti = idApprenti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackApprentiEntity that = (FeedbackApprentiEntity) o;

        if (idFeedbackApprenti != that.idFeedbackApprenti) return false;
        if (idApprenti != that.idApprenti) return false;
        if (avis != null ? !avis.equals(that.avis) : that.avis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFeedbackApprenti;
        result = 31 * result + (avis != null ? avis.hashCode() : 0);
        result = 31 * result + idApprenti;
        return result;
    }
}
