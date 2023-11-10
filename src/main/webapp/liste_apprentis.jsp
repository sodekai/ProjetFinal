<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" %>


<div class="container card bordered" id="container-lg-liste-apprentis">
    <h1>Liste des apprentis</h1>
    <button onclick='location.href="search-apprenti.html"'>
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
        </svg> Rechercher des apprentis
    </button>
    <div class="container card bordered" id="container-resultList_apprentis">
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
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ requestScope.tuteurApprentiList }" var="apprenti">
            <c:choose>
            <c:when test="${!apprenti.isEst_archive()}">
            <tr>
                <td>${ apprenti.utilisateur.personne.nom }</td>
                <td><c:out value="${ apprenti.utilisateur.personne.prenom }"/></td>
                <td><c:out value="${ apprenti.entreprise.raisonSociale }"/></td>
                <td><c:out value="${ apprenti.anneeAcademique }"/></td>
                <td><c:out value="${ apprenti.majeure}"/></td>
                <td><c:out value="${ apprenti.mission.metierCible }"/></td>
                <td><c:out value="${ apprenti.maitreApprentissage.personne.nom }"/></td>
                <td><c:out value="${ apprenti.tuteur.utilisateur.personne.nom }"/></td>
                <td>
                    <button onclick="location.href='/apprenti-infos/<c:out value='${apprenti.idApprenti}'/>'">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
                            <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
                            <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
                        </svg>
                    </button>
                    <form action="archiver-apprenti" method="post" style="border: unset; background-color: unset;">
                        <input type="hidden" name="apprentiId" value="${ apprenti.idApprenti }">
                        <button type="submit">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                            <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
                            </svg>
                        </button>
                    </form>
                </td>
            </tr>
            </c:when>
            </c:choose>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
<%@ include file="footer.jsp" %>
