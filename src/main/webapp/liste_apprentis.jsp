<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" %>

<h1>Liste des apprentis</h1>
<div class="container card bordered" id="container-liste_apprentis">
    <table class="tutorat-table tutorat-table-liste">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${ requestScope.tuteurApprentiList }" var="apprenti">
            <tr>
                <td><c:out value="${ apprenti.utilisateur.nomUtilisateur }" /></td>
                <td>features</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="footer.jsp"%>
