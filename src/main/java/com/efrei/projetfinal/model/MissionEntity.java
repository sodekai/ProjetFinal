package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mission", schema = "tutorat", catalog = "")
public class MissionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_mission", nullable = false)
    private int idMission;
    @Basic
    @Column(name = "mots_cles", nullable = true, length = 150)
    private String motsCles;
    @Basic
    @Column(name = "metier_cible", nullable = true, length = 150)
    private String metierCible;
    @Basic
    @Column(name = "commentaires", nullable = true, length = 150)
    private String commentaires;
    @Basic
    @Column(name = "id_apprenti", nullable = true)
    private Integer idApprenti;

    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    public String getMetierCible() {
        return metierCible;
    }

    public void setMetierCible(String metierCible) {
        this.metierCible = metierCible;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public Integer getIdApprenti() {
        return idApprenti;
    }

    public void setIdApprenti(Integer idApprenti) {
        this.idApprenti = idApprenti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionEntity that = (MissionEntity) o;

        if (idMission != that.idMission) return false;
        if (motsCles != null ? !motsCles.equals(that.motsCles) : that.motsCles != null) return false;
        if (metierCible != null ? !metierCible.equals(that.metierCible) : that.metierCible != null) return false;
        if (commentaires != null ? !commentaires.equals(that.commentaires) : that.commentaires != null) return false;
        if (idApprenti != null ? !idApprenti.equals(that.idApprenti) : that.idApprenti != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMission;
        result = 31 * result + (motsCles != null ? motsCles.hashCode() : 0);
        result = 31 * result + (metierCible != null ? metierCible.hashCode() : 0);
        result = 31 * result + (commentaires != null ? commentaires.hashCode() : 0);
        result = 31 * result + (idApprenti != null ? idApprenti.hashCode() : 0);
        return result;
    }
}
