package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tuteur", schema = "tutorat", catalog = "")
public class TuteurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Utilisateur", nullable = false)
    private int idUtilisateur;

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

        if (idUtilisateur != that.idUtilisateur) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idUtilisateur;
    }
}
