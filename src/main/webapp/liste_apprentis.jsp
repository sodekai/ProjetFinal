<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" %>

<head>
    <title>Liste des Apprentis</title>
</head>
<body>
<h1>Liste des Apprentis</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Année Académique</th>
        <th>Majeure</th>
    </tr>
    <c:forEach var="apprenti" items="${apprentis}">
        <tr>
            <td>${apprenti.idApprenti}</td>
            <td>${apprenti.utilisateur.nom}</td>
            <td>${apprenti.utilisateur.prenom}</td>
            <td>${apprenti.anneeAcademique}</td>
            <td>${apprenti.majeure}</td>
        </tr>
    </c:forEach>
</table>
</body>
<%@ include file="footer.jsp"%>
