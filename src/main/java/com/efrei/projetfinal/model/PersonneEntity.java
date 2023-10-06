package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personne", schema = "tutorat", catalog = "")
public class PersonneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_personne", nullable = false)
    private int idPersonne;
    @Basic
    @Column(name = "nom", nullable = true, length = 50)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = true, length = 50)
    private String prenom;
    @Basic
    @Column(name = "adresse_electronique", nullable = true, length = 50)
    private String adresseElectronique;
    @Basic
    @Column(name = "telephone", nullable = true, length = 10)
    private String telephone;

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseElectronique() {
        return adresseElectronique;
    }

    public void setAdresseElectronique(String adresseElectronique) {
        this.adresseElectronique = adresseElectronique;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonneEntity that = (PersonneEntity) o;

        if (idPersonne != that.idPersonne) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (adresseElectronique != null ? !adresseElectronique.equals(that.adresseElectronique) : that.adresseElectronique != null)
            return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPersonne;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (adresseElectronique != null ? adresseElectronique.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }
}
