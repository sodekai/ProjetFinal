package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tuteur", schema = "tutorat", catalog = "")
@NamedQueries({
        @NamedQuery(
                name = "TuteurEntity.findAll",
                query = "SELECT t FROM TuteurEntity t"
        ),
        @NamedQuery(
                name = "TuteurEntity.findById",
                query = "SELECT t FROM TuteurEntity t WHERE t.idTuteur = :idTuteur"
        ),
        @NamedQuery(
                name = "TuteurEntity.getTuteurUserId",
                query = "SELECT t FROM TuteurEntity t WHERE t.utilisateur = :idTuteur"
        ),
        @NamedQuery(
                name = "TuteurEntity.findAllApprentisByTuteurId",
                query = "SELECT a FROM ApprentiEntity a WHERE a.tuteur.idTuteur = :idTuteur"
        ),
        @NamedQuery(
                name = "TuteurEntity.findAllApprentisByTuteurUserId",
                query = "SELECT a FROM ApprentiEntity a WHERE a.tuteur.utilisateur.idUtilisateur = :idTuteurUser"
        ),
        @NamedQuery(
                name = "TuteurEntity.updateUtilisateur",
                query = "UPDATE TuteurEntity t SET t.utilisateur = :utilisateur WHERE t.idTuteur = :idTuteur"
        )

})

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

    public void setUtilisateur(UtilisateurEntity utilisateur) {
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
