package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tuteur", schema = "tutorat", catalog = "")
public class TuteurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tuteur", nullable = false)
    private int idTuteur;

    @OneToOne
    @JoinColumn(name = "id_utilisateur")
    private UtilisateurEntity utilisateur;

    public int getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(int idTuteur) {
        this.idTuteur = idTuteur;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public void setIdUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TuteurEntity that = (TuteurEntity) o;

        if (idTuteur != that.idTuteur) return false;
        if (utilisateur != that.utilisateur) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTuteur;
        result = 31 * result + (utilisateur != null ? utilisateur.hashCode() : 0);
        return result;
    }
}
