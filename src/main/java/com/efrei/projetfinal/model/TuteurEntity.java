package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tuteur", schema = "tutorat", catalog = "")
public class TuteurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tuteur", nullable = false)
    private int idTuteur;
    @Basic
    @Column(name = "id_utilisateur", nullable = false)
    private int idUtilisateur;

    public int getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(int idTuteur) {
        this.idTuteur = idTuteur;
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

        TuteurEntity that = (TuteurEntity) o;

        if (idTuteur != that.idTuteur) return false;
        if (idUtilisateur != that.idUtilisateur) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTuteur;
        result = 31 * result + idUtilisateur;
        return result;
    }
}
