package com.efrei.projetfinal;

public class Apprenti extends Utilisateur {

    private String anneeAcademique;
    private String majeure;
    private Entreprise entreprise;
    private FeedbackApprenti feedback;
    private EvaluationEcole evaluation;


    public Apprenti(String nom, String prenom, String adresseElectronique, String telephone,String nomUtilisateur, String motDePasse, String anneeAcademique, String majeure, Entreprise entreprise) {
        super(nom, prenom, adresseElectronique, telephone, nomUtilisateur, motDePasse);
        this.anneeAcademique = anneeAcademique;
        this.majeure = majeure;
        this.entreprise = entreprise;
    }

    public void setAnneeAcademique(String anneeAcademique){
        this.anneeAcademique = anneeAcademique;
    }
    public void setMajeure(String majeure){
        this.majeure = majeure;
    }
    public void setEntreprise(Entreprise entreprise){
        this.entreprise = entreprise;
    }
    public void setFeedback(FeedbackApprenti feedback){
        this.feedback = feedback;
    }

    public void setEvaluation(EvaluationEcole evaluation){
        this.evaluation = evaluation;
    }


}
