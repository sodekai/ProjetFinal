package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur", schema = "tutorat", catalog = "")
public class UtilisateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Utilisateur", nullable = false)
    private int idUtilisateur;
    @Basic
    @Column(name = "NomUtilisateur", nullable = true, length = 100)
    private String nomUtilisateur;
    @Basic
    @Column(name = "MotDePasse", nullable = true, length = 50)
    private String motDePasse;
    @Basic
    @Column(name = "ID_personne", nullable = false)
    private int idPersonne;

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UtilisateurEntity that = (UtilisateurEntity) o;

        if (idUtilisateur != that.idUtilisateur) return false;
        if (idPersonne != that.idPersonne) return false;
        if (nomUtilisateur != null ? !nomUtilisateur.equals(that.nomUtilisateur) : that.nomUtilisateur != null)
            return false;
        if (motDePasse != null ? !motDePasse.equals(that.motDePasse) : that.motDePasse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUtilisateur;
        result = 31 * result + (nomUtilisateur != null ? nomUtilisateur.hashCode() : 0);
        result = 31 * result + (motDePasse != null ? motDePasse.hashCode() : 0);
        result = 31 * result + idPersonne;
        return result;
    }
}
