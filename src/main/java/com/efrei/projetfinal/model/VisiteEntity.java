package com.efrei.projetfinal.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "visite", schema = "tutorat", catalog = "")
public class VisiteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_visite", nullable = false)
    private int idVisite;
    @Basic
    @Column(name = "date_visite", nullable = true)
    private Date dateVisite;
    @Basic
    @Column(name = "format", nullable = true, length = 50)
    private String format;
    @Basic
    @Column(name = "compte_rendu", nullable = true, length = 150)
    private String compteRendu;
    @Basic
    @Column(name = "id_apprenti", nullable = false)
    private int idApprenti;

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

    public int getIdApprenti() {
        return idApprenti;
    }

    public void setIdApprenti(int idApprenti) {
        this.idApprenti = idApprenti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisiteEntity that = (VisiteEntity) o;

        if (idVisite != that.idVisite) return false;
        if (idApprenti != that.idApprenti) return false;
        if (dateVisite != null ? !dateVisite.equals(that.dateVisite) : that.dateVisite != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        if (compteRendu != null ? !compteRendu.equals(that.compteRendu) : that.compteRendu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVisite;
        result = 31 * result + (dateVisite != null ? dateVisite.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (compteRendu != null ? compteRendu.hashCode() : 0);
        result = 31 * result + idApprenti;
        return result;
    }
}