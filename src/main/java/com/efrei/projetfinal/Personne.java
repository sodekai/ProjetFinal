package com.efrei.projetfinal;

public class Personne {
    private String nom;
    private String prenom;
    private String adresseElectronique;

    private String telephone;

    public Personne(String nom, String prenom, String adresseElectronique, String telephone){
        this.nom = nom;
        this.prenom = prenom;
        this.adresseElectronique = adresseElectronique;
        this.telephone = telephone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresseElectronique(String adresseElectronique) {
        this.adresseElectronique = adresseElectronique;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }

    public String getAdresseElectronique() {
        return adresseElectronique;
    }
    public String getTelephone() {
        return this.telephone;
    }
}
