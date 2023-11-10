package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "MaitreApprentissageEntity.findAll",
                query = "SELECT m FROM MaitreApprentissageEntity m"
        ),
        @NamedQuery(
                name = "MaitreApprentissageEntity.findById",
                query = "SELECT m FROM MaitreApprentissageEntity m WHERE m.idMaitreApprentissage = :idMaitreApprentissage"
        ),
        @NamedQuery(
                name = "MaitreApprentissageEntity.update",
                query = "UPDATE MaitreApprentissageEntity m SET m.remarque = :remarque, m.poste = :poste, m.entreprise = :entreprise, m.personne = :personne WHERE m.idMaitreApprentissage = :idMaitreApprentissage"
        )

})
@Table(name = "maitre_apprentissage", schema = "tutorat", catalog = "")
public class MaitreApprentissageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_maitre_apprentissage", nullable = false)
    private int idMaitreApprentissage;
    @Basic
    @Column(name = "remarque", nullable = true, length = 150)
    private String remarque;
    @Basic
    @Column(name = "poste", nullable = true, length = 150)
    private String poste;

    @OneToOne
    @JoinColumn(name = "id_entreprise")
    private EntrepriseEntity entreprise;
    @OneToOne
    @JoinColumn(name = "id_personne")
    private PersonneEntity personne;

    public int getIdMaitreApprentissage() {
        return idMaitreApprentissage;
    }

    public void setIdMaitreApprentissage(int idMaitreApprentissage) {
        this.idMaitreApprentissage = idMaitreApprentissage;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public EntrepriseEntity getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(EntrepriseEntity entreprise) {
        this.entreprise = entreprise;
    }

    public PersonneEntity getPersonne() {
        return personne;
    }

    public void setPersonne(PersonneEntity personne) {
        this.personne = personne;
    }

    public int getId() {
        return idMaitreApprentissage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaitreApprentissageEntity that = (MaitreApprentissageEntity) o;

        if (idMaitreApprentissage != that.idMaitreApprentissage) return false;
        if (personne != that.personne) return false;
        if (remarque != null ? !remarque.equals(that.remarque) : that.remarque != null) return false;
        if (poste != null ? !poste.equals(that.poste) : that.poste != null) return false;
        if (entreprise != null ? !entreprise.equals(that.entreprise) : that.entreprise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMaitreApprentissage;
        result = 31 * result + (remarque != null ? remarque.hashCode() : 0);
        result = 31 * result + (poste != null ? poste.hashCode() : 0);
        result = 31 * result + (entreprise != null ? entreprise.hashCode() : 0);
        result = 31 * result + (personne != null ? personne.hashCode() : 0);
        return result;
    }
}
