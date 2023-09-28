package model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "visite", schema = "tutorat", catalog = "")
public class VisiteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_visite", nullable = false)
    private int idVisite;
    @Basic
    @Column(name = "DateVisite", nullable = true)
    private Date dateVisite;
    @Basic
    @Column(name = "Format", nullable = true, length = 50)
    private String format;
    @Basic
    @Column(name = "CompteRendu", nullable = true, length = 150)
    private String compteRendu;
    @Basic
    @Column(name = "ID_Utilisateur", nullable = true)
    private Integer idUtilisateur;

    public int getIdVisite() {
        return idVisite;
    }

    public void setIdVisite(int idVisite) {
        this.idVisite = idVisite;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisiteEntity that = (VisiteEntity) o;

        if (idVisite != that.idVisite) return false;
        if (dateVisite != null ? !dateVisite.equals(that.dateVisite) : that.dateVisite != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        if (compteRendu != null ? !compteRendu.equals(that.compteRendu) : that.compteRendu != null) return false;
        if (idUtilisateur != null ? !idUtilisateur.equals(that.idUtilisateur) : that.idUtilisateur != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVisite;
        result = 31 * result + (dateVisite != null ? dateVisite.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (compteRendu != null ? compteRendu.hashCode() : 0);
        result = 31 * result + (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return result;
    }
}
