package model;

import jakarta.persistence.*;

@Entity
@Table(name = "maitreapprentissage", schema = "tutorat", catalog = "")
public class MaitreapprentissageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_personne", nullable = false)
    private int idPersonne;
    @Basic
    @Column(name = "Remarque", nullable = true, length = 150)
    private String remarque;
    @Basic
    @Column(name = "Poste", nullable = true, length = 150)
    private String poste;
    @Basic
    @Column(name = "ID_entreprise", nullable = true)
    private Integer idEntreprise;

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
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

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaitreapprentissageEntity that = (MaitreapprentissageEntity) o;

        if (idPersonne != that.idPersonne) return false;
        if (remarque != null ? !remarque.equals(that.remarque) : that.remarque != null) return false;
        if (poste != null ? !poste.equals(that.poste) : that.poste != null) return false;
        if (idEntreprise != null ? !idEntreprise.equals(that.idEntreprise) : that.idEntreprise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPersonne;
        result = 31 * result + (remarque != null ? remarque.hashCode() : 0);
        result = 31 * result + (poste != null ? poste.hashCode() : 0);
        result = 31 * result + (idEntreprise != null ? idEntreprise.hashCode() : 0);
        return result;
    }
}
