<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" %>

<h1>Liste des apprentis</h1>
<div class="container card bordered" id="container-liste_apprentis">
    <table class="tutorat-table tutorat-table-liste">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Entreprise</th>
            <th>Année académique</th>
            <th>Majeure</th>
            <th>Mission</th>
            <th>Maitre d'apprentissage</th>
            <th>Tuteur</th>
            <th>Apprenti info</th>
            <th>Archiver</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ requestScope.tuteurApprentiList }" var="apprenti">
            <c:when test="${not apprenti.est_archive}">
            <tr>
                <td><c:out value="${ apprenti.utilisateur.personne.nom }"/></td>
                <td><c:out value="${ apprenti.utilisateur.personne.prenom }"/></td>
                <td><c:out value="${ apprenti.entreprise.raisonSociale }"/></td>
                <td><c:out value="${ apprenti.anneeAcademique }"/></td>
                <td><c:out value="${ apprenti.majeure.mission.motsCles }"/></td>
                <td><c:out value="${ apprenti.maitreApprentissage.personne.nom }"/></td>
                <td><c:out value="${ apprenti.tuteur.personne.nom }"/></td>
                <td><c:out value="${ apprenti.utilisateur.nomUtilisateur }"/></td>
                <td><a href="/apprenti-infos/<c:out value='${apprenti.idApprenti}'/>">modifier</a></td>
                <td><form action="welcome-tuteur" method="post" class="container card bordered">
                    <input type="hidden" name="apprentiId" value="${ apprenti.idApprenti }">
                    <input type="submit" value="Welcome Apprenti">
                </form></td>
            </tr>
            </c:when>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="footer.jsp" %>
