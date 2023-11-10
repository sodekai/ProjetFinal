package com.efrei.projetfinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apprenti", schema = "tutorat", catalog = "")
@NamedQueries({
        @NamedQuery(
                name = "ApprentiEntity.findAll",
                query = "SELECT a FROM ApprentiEntity a"
        ),
        @NamedQuery(
                name = "ApprentiEntity.findById",
                query = "SELECT a FROM ApprentiEntity a WHERE a.idApprenti = :idApprenti"
        ),
        @NamedQuery(
                name = "ApprentiEntity.findAllApprentisByNom",
                query = "SELECT a FROM ApprentiEntity a WHERE a.utilisateur.personne.nom = :nom OR a.utilisateur.personne.prenom = :nom"
        ),
        @NamedQuery(
                name = "ApprentiEntity.findAllApprentisByEntreprise",
                query = "SELECT a FROM ApprentiEntity a WHERE a.entreprise.raisonSociale = :raisonSociale"
        ),
        @NamedQuery(
                name = "ApprentiEntity.findAllApprentisByMotCleMission",
                query = "SELECT a FROM ApprentiEntity a WHERE a.mission.motsCles LIKE :motCleMission"
        ),
        @NamedQuery(
                name = "ApprentiEntity.findAllApprentisByAnneeAcademique",
                query = "SELECT a FROM ApprentiEntity a WHERE a.anneeAcademique = :anneeAcademique"
        ),
        @NamedQuery(
                name = "ApprentiEntity.findAllApprentisByTuteur",
                query = "SELECT a FROM ApprentiEntity a WHERE a.tuteur = :idTuteur"
        ),
        @NamedQuery(
                name = "ApprentiEntity.findAllVisitesByApprentiId",
                query = "SELECT v FROM VisiteEntity v WHERE v.apprenti.idApprenti = :idApprenti"
        ),
        @NamedQuery(
                name = "ApprentiEntity.findAllFeedbacksByApprentiId",
                query = "SELECT f FROM FeedbackApprentiEntity f WHERE f.apprenti.idApprenti = :idApprenti"
        ),
        @NamedQuery(
                name = "ApprentiEntity.findAllEvaluationsEcoleByApprentiId",
                query = "SELECT e FROM EvaluationEcoleEntity e WHERE e.apprenti.idApprenti = :idApprenti"
        ),
        @NamedQuery(
                name = "ApprentiEntity.findByUtilisateurId",
                query = "SELECT a FROM ApprentiEntity a WHERE a.utilisateur.idUtilisateur = :idUtilisateur"
        ),
        @NamedQuery(
                name = "ApprentiEntity.update",
                query = "UPDATE ApprentiEntity a SET a.anneeAcademique = :anneeAcademique, a.majeure = :majeure, a.utilisateur = :utilisateur WHERE a.idApprenti = :idApprenti"
        ),
        @NamedQuery(
                name = "ApprentiEntity.updateArchive",
                query = "UPDATE ApprentiEntity a SET a.est_archive = false WHERE a.idApprenti = :idApprenti"
        )
})
public class ApprentiEntity {
    public ApprentiEntity(int idApprenti, String anneeAcademique, String majeure, boolean est_archive, TuteurEntity tuteur, MaitreApprentissageEntity maitreApprentissage, EntrepriseEntity entreprise, UtilisateurEntity utilisateur, MissionEntity mission) {
        this.idApprenti = idApprenti;
        this.anneeAcademique = anneeAcademique;
        this.majeure = majeure;
        this.est_archive = est_archive;
        this.tuteur = tuteur;
        this.maitreApprentissage = maitreApprentissage;
        this.entreprise = entreprise;
        this.utilisateur = utilisateur;
        this.mission = mission;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_apprenti", nullable = false)
    private int idApprenti;

    public void setEst_archive(boolean est_archive) {
        this.est_archive = est_archive;
    }

    @Basic
    @Column(name = "annee_academique", nullable = true, length = 150)
    private String anneeAcademique;
    @Basic
    @Column(name = "majeure", nullable = true, length = 150)
    private String majeure;

    @Basic
    @Column(name = "est_archive", nullable = false, length = 1)
    private boolean est_archive;
    /*
    @Basic
    @Column(name = "id_tuteur", nullable = true)
    private Integer idTuteur;
    @Basic
    @Column(name = "id_maitre_apprentissage", nullable = true)
    private Integer idMaitreApprentissage;
    @Basic
    @Column(name = "id_entreprise", nullable = true)
    private Integer idEntreprise;

    @Basic
    @Column(name = "id_utilisateur", nullable = false)
    private int idUtilisateur;
    */
    @OneToOne
    @JoinColumn(name = "id_tuteur")
    private TuteurEntity tuteur;
    @OneToOne
    @JoinColumn(name = "id_maitre_apprentissage")
    private MaitreApprentissageEntity maitreApprentissage;
    @OneToOne
    @JoinColumn(name = "id_entreprise")
    private EntrepriseEntity entreprise;
    @OneToOne
    @JoinColumn(name = "id_utilisateur")
    private UtilisateurEntity utilisateur;

    @OneToOne
    @JoinColumn(name = "id_mission")
    private MissionEntity mission;

    public ApprentiEntity() {

    }

    public int getIdApprenti() {
        return idApprenti;
    }

    public void setIdApprenti(int idApprenti) {
        this.idApprenti = idApprenti;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public String getMajeure() {
        return majeure;
    }

    public void setMajeure(String majeure) {
        this.majeure = majeure;
    }

    public MissionEntity getMission() {
        return mission;
    }

    public void setMission(MissionEntity mission) {
        this.mission = mission;
    }

    public TuteurEntity getTuteur() {
        return tuteur;
    }

    public void setTuteur(TuteurEntity tuteur) {
        this.tuteur = tuteur;
    }

    public MaitreApprentissageEntity getMaitreApprentissage() {
        return maitreApprentissage;
    }

    public void setIdMaitreApprentissage(MaitreApprentissageEntity maitreApprentissage) {
        this.maitreApprentissage = maitreApprentissage;
    }

    public EntrepriseEntity getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(EntrepriseEntity Entreprise) {
        this.entreprise = Entreprise;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    public boolean isEst_archive() {
        return est_archive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprentiEntity that = (ApprentiEntity) o;

        if (idApprenti != that.idApprenti) return false;
        if (utilisateur != that.utilisateur) return false;
        if (est_archive != that.est_archive) return false;
        if (anneeAcademique != null ? !anneeAcademique.equals(that.anneeAcademique) : that.anneeAcademique != null)
            return false;
        if (majeure != null ? !majeure.equals(that.majeure) : that.majeure != null) return false;
        if (tuteur != null ? !tuteur.equals(that.tuteur) : that.tuteur != null) return false;
        if (maitreApprentissage != null ? !maitreApprentissage.equals(that.maitreApprentissage) : that.maitreApprentissage != null)
            return false;
        if (entreprise != null ? !entreprise.equals(that.entreprise) : that.entreprise != null) return false;
        if (mission != null ? !mission.equals(that.mission) : that.mission != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = idApprenti;
        result = 31 * result + (anneeAcademique != null ? anneeAcademique.hashCode() : 0);
        result = 31 * result + (majeure != null ? majeure.hashCode() : 0);
        result = 31 * result + (tuteur != null ? tuteur.hashCode() : 0);
        result = 31 * result + (est_archive ? 1 : 0);
        result = 31 * result + (maitreApprentissage != null ? maitreApprentissage.hashCode() : 0);
        result = 31 * result + (entreprise != null ? entreprise.hashCode() : 0);
        result = 31 * result + (utilisateur != null ? utilisateur.hashCode() : 0);
        result = 31 * result + (mission != null ? mission.hashCode() : 0);
        return result;
    }
}
