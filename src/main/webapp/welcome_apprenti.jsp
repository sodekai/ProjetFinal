<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" %>

<div class="bubbles-container">
    <div class="bubble-infos bubble-infos-small">
        <h1>Informations générales</h1>
        <table class="tutorat-table">
            <tr>
                <td class="tutorat-table-label">Nom</td>
                <td>${requestScope.apprenti.utilisateur.personne.nom}</td>
            </tr>
            <tr>
                <td class="tutorat-table-label">Prénom</td>
                <td>${requestScope.apprenti.utilisateur.personne.prenom}</td>
            </tr>
            <tr>
                <td class="tutorat-table-label">Majeure</td>
                <td>${requestScope.apprenti.majeure}</td>
            </tr>
            <tr>
                <td class="tutorat-table-label">Tuteur</td>
                <td>${requestScope.apprenti.tuteur.utilisateur.personne.prenom} ${requestScope.apprenti.tuteur.utilisateur.personne.nom}</td>
            </tr>
        </table>
    </div>

    <div class="bubble-infos bubble-infos-small">
        <h1>Entreprise</h1>
        <table class="tutorat-table">
            <tr>
                <td class="tutorat-table-label">Raison sociale</td>
                <td>${requestScope.apprenti.entreprise.raisonSociale}</td>
            </tr>
            <tr>
                <td class="tutorat-table-label">Adresse</td>
                <td>${requestScope.apprenti.entreprise.adresse}</td>
            </tr>
            <tr>
                <td class="tutorat-table-label">Informations utiles</td>
                <td>${requestScope.apprenti.entreprise.informationsUtiles}</td>
            </tr>
        </table>
    </div>

    <div class="bubble-infos bubble-infos-large">
        <h1>Mission</h1>
        <table class="tutorat-table">
            <tr>
                <td class="tutorat-table-label">Mots-clés</td>
                <td>${requestScope.apprenti.mission.motsCles}</td>
            </tr>
            <tr>
                <td class="tutorat-table-label">Métier cible</td>
                <td>${requestScope.apprenti.mission.metierCible}</td>
            </tr>
            <tr>
                <td class="tutorat-table-label">Commentaires</td>
                <td>${requestScope.apprenti.mission.commentaires}</td>
            </tr>
        </table>
    </div>

    <div class="bubble-infos bubble-infos-large">
        <h1>Mes Visites</h1>
        <table class="tutorat-table tutorat-table-liste">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Format</th>
                    <th>Compte-rendu</th>
                </tr>
            </thead>
            <tbody>
            <tr>
                <td>...</td>
                <td>...</td>
                <td>...</td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="bubble-infos bubble-infos-large">
        <h1>Mes Feedbacks</h1>
        <table class="tutorat-table tutorat-table-liste">
            <thead>
                <tr>
                    <th style="width: 10%">No</th>
                    <th>Avis</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>...</td>
                    <td>...</td>
                </tr>
            </tbody>
        </table>
    </div>

    <div class="bubble-infos bubble-infos-large">
        <h1>Mes Evaluations</h1>

        <div class="bubble-infos-dark">
            <h3>Evaluation #...</h3>
            <div class="bubbles-container">

                <div class="bubble-infos bubble-infos-small bordered-thin">
                    <h4>Soutenance #...</h4>
                    <table class="tutorat-table">
                        <tr>
                            <td class="tutorat-table-label">Date</td>
                            <td>...</td>
                        </tr>
                        <tr>
                            <td class="tutorat-table-label">Commentaire</td>
                            <td>...</td>
                        </tr>
                        <tr>
                            <td class="tutorat-table-label">Note finale</td>
                            <td>...</td>
                        </tr>
                    </table>
                </div>

                <div class="bubble-infos bubble-infos-small bordered-thin">
                    <h4>Mémoire #...</h4>
                    <table class="tutorat-table">
                        <tr>
                            <td class="tutorat-table-label">Thème</td>
                            <td>...</td>
                        </tr>
                        <tr>
                            <td class="tutorat-table-label">Commentaire</td>
                            <td>...</td>
                        </tr>
                        <tr>
                            <td class="tutorat-table-label">Note finale</td>
                            <td>...</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>
<%@ include file="footer.jsp"%>