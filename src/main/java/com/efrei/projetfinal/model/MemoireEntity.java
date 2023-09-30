package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "memoire", schema = "tutorat", catalog = "")
public class MemoireEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_memoire", nullable = false)
    private int idMemoire;
    @Basic
    @Column(name = "Theme", nullable = true, length = 150)
    private String theme;
    @Basic
    @Column(name = "NoteFinale", nullable = true, precision = 0)
    private Double noteFinale;
    @Basic
    @Column(name = "Commentaire", nullable = true, length = 150)
    private String commentaire;

    public int getIdMemoire() {
        return idMemoire;
    }

    public void setIdMemoire(int idMemoire) {
        this.idMemoire = idMemoire;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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

        MemoireEntity that = (MemoireEntity) o;

        if (idMemoire != that.idMemoire) return false;
        if (theme != null ? !theme.equals(that.theme) : that.theme != null) return false;
        if (noteFinale != null ? !noteFinale.equals(that.noteFinale) : that.noteFinale != null) return false;
        if (commentaire != null ? !commentaire.equals(that.commentaire) : that.commentaire != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMemoire;
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (noteFinale != null ? noteFinale.hashCode() : 0);
        result = 31 * result + (commentaire != null ? commentaire.hashCode() : 0);
        return result;
    }
}
