package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbackapprenti", schema = "tutorat", catalog = "")
public class FeedbackapprentiEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_FeedBack", nullable = false)
    private int idFeedBack;

    public int getIdFeedBack() {
        return idFeedBack;
    }

    public void setIdFeedBack(int idFeedBack) {
        this.idFeedBack = idFeedBack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackapprentiEntity that = (FeedbackapprentiEntity) o;

        if (idFeedBack != that.idFeedBack) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idFeedBack;
    }
}
