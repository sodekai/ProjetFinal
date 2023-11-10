package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entreprise", schema = "tutorat", catalog = "")
@NamedQueries({
        @NamedQuery(
                name = "EntrepriseEntity.findAll",
                query = "SELECT e FROM EntrepriseEntity e"
        ),
        @NamedQuery(
                name = "EntrepriseEntity.findById",
                query = "SELECT e FROM EntrepriseEntity e WHERE e.idEntreprise = :idEntreprise"
        ),
        @NamedQuery(
                name = "EntrepriseEntity.delete",
                query = "DELETE FROM EntrepriseEntity e WHERE e.idEntreprise = :idEntreprise"
        ),
        @NamedQuery(
                name = "EntrepriseEntity.update",
                query = "UPDATE EntrepriseEntity e SET e.raisonSociale = :raisonSociale, e.adresse = :adresse, e.informationsUtiles = :informationsUtiles WHERE e.idEntreprise = :idEntreprise"
        ),
        @NamedQuery(
                name = "EntrepriseEntity.create",
                query = "INSERT INTO EntrepriseEntity e (e.raisonSociale, e.adresse, e.informationsUtiles) VALUES (:raisonSociale, :adresse, :informationsUtiles)"
        )
})
public class EntrepriseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_entreprise", nullable = false)
    private int idEntreprise;
    @Basic
    @Column(name = "raison_sociale", nullable = true, length = 50)
    private String raisonSociale;
    @Basic
    @Column(name = "adresse", nullable = true, length = 150)
    private String adresse;
    @Basic
    @Column(name = "informations_utiles", nullable = true, length = 150)
    private String informationsUtiles;

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getInformationsUtiles() {
        return informationsUtiles;
    }

    public void setInformationsUtiles(String informationsUtiles) {
        this.informationsUtiles = informationsUtiles;
    }

    public int getId() {
        return idEntreprise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntrepriseEntity that = (EntrepriseEntity) o;

        if (idEntreprise != that.idEntreprise) return false;
        if (raisonSociale != null ? !raisonSociale.equals(that.raisonSociale) : that.raisonSociale != null)
            return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        if (informationsUtiles != null ? !informationsUtiles.equals(that.informationsUtiles) : that.informationsUtiles != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEntreprise;
        result = 31 * result + (raisonSociale != null ? raisonSociale.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (informationsUtiles != null ? informationsUtiles.hashCode() : 0);
        return result;
    }
}
