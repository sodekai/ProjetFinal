package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur", schema = "tutorat", catalog = "")
@NamedQueries({
        @NamedQuery(
                name = "UtilisateurEntity.findAll",
                query = "SELECT u FROM UtilisateurEntity u"
        ),
        @NamedQuery(
                name = "UtilisateurEntity.findById",
                query = "SELECT u FROM UtilisateurEntity u WHERE u.idUtilisateur = :idUtilisateur"
        ),
        @NamedQuery(
                name = "UtilisateurEntity.updateDetailsById",
                query = "UPDATE UtilisateurEntity u SET u.nomUtilisateur = :nomUtilisateur, u.motDePasse = :motDePasse WHERE u.idUtilisateur = :idUtilisateur"
        ),
        @NamedQuery(
                name = "UtilisateurEntity.findByIdentifiers",
                query = "SELECT u FROM UtilisateurEntity u WHERE u.nomUtilisateur = :nomUtilisateur AND u.motDePasse = :motDePasse"
        )

})
public class UtilisateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_utilisateur", nullable = false)
    private int idUtilisateur;
    @Basic
    @Column(name = "nom_utilisateur", nullable = true, length = 100)
    private String nomUtilisateur;
    @Basic
    @Column(name = "mot_de_passe", nullable = true, length = 50)
    private String motDePasse;
    @Basic
    @Column(name = "role_utilisateur", nullable = true, length = 50)
    private String roleUtilisateur;

    @OneToOne
    @JoinColumn(name = "id_personne")
    private PersonneEntity personne;

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

    public PersonneEntity getPersonne() {
        return personne;
    }

    public void setPersonne(PersonneEntity idPersonne) {
        this.personne = personne;
    }

    public String getRoleUtilisateur() {
        return roleUtilisateur;
    }
    public void setRoleUtilisateur(String roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UtilisateurEntity that = (UtilisateurEntity) o;

        if (idUtilisateur != that.idUtilisateur) return false;
        if (personne != that.personne) return false;
        if (nomUtilisateur != null ? !nomUtilisateur.equals(that.nomUtilisateur) : that.nomUtilisateur != null)
            return false;
        if (motDePasse != null ? !motDePasse.equals(that.motDePasse) : that.motDePasse != null) return false;
        if (roleUtilisateur != null ? !roleUtilisateur.equals(that.roleUtilisateur) : that.roleUtilisateur != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = idUtilisateur;
        result = 31 * result + (nomUtilisateur != null ? nomUtilisateur.hashCode() : 0);
        result = 31 * result + (motDePasse != null ? motDePasse.hashCode() : 0);
        result = 31 * result + (personne != null ? personne.hashCode() : 0);
        result = 31 * result + (roleUtilisateur != null ? roleUtilisateur.hashCode() : 0);
        return result;
    }
}
