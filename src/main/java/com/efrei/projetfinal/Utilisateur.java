package com.efrei.projetfinal;

import jakarta.persistence.EntityManager;

public class Utilisateur extends Personne{
    private String nomUtilisateur;
    private String motDePasse;

    public Utilisateur(String nom, String prenom, String adresseElectronique, String telephone, String nomUtilisateur, String motDePasse){
        super(nom, prenom, adresseElectronique, telephone);
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
