package com.efrei.projetfinal.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "soutenance", schema = "tutorat", catalog = "")
public class SoutenanceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_soutenance", nullable = false)
    private int idSoutenance;
    @Basic
    @Column(name = "date_soutenance", nullable = true)
    private Date dateSoutenance;
    @Basic
    @Column(name = "note_finale", nullable = true, precision = 0)
    private Double noteFinale;
    @Basic
    @Column(name = "commentaire", nullable = true, length = 150)
    private String commentaire;

    public int getIdSoutenance() {
        return idSoutenance;
    }

    public void setIdSoutenance(int idSoutenance) {
        this.idSoutenance = idSoutenance;
    }

    public Date getDateSoutenance() {
        return dateSoutenance;
    }

    public void setDateSoutenance(Date dateSoutenance) {
        this.dateSoutenance = dateSoutenance;
    }

    public Double getNoteFinale() {
        return noteFinale;
    }

    public void setNoteFinale(Double noteFinale) {
        this.noteFinale = noteFinale;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoutenanceEntity that = (SoutenanceEntity) o;

        if (idSoutenance != that.idSoutenance) return false;
        if (dateSoutenance != null ? !dateSoutenance.equals(that.dateSoutenance) : that.dateSoutenance != null)
            return false;
        if (noteFinale != null ? !noteFinale.equals(that.noteFinale) : that.noteFinale != null) return false;
        if (commentaire != null ? !commentaire.equals(that.commentaire) : that.commentaire != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSoutenance;
        result = 31 * result + (dateSoutenance != null ? dateSoutenance.hashCode() : 0);
        result = 31 * result + (noteFinale != null ? noteFinale.hashCode() : 0);
        result = 31 * result + (commentaire != null ? commentaire.hashCode() : 0);
        return result;
    }
}
