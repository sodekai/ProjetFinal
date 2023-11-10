
<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suivi Tutorat</title>
    <link  rel="stylesheet" type="text/css" href="http://localhost:8080/tutoratApprentis/assets/css/style.css" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>

<body>
<div id="header">
    <div id="menu">
        <div>
            <c:choose>
                <c:when test="${sessionScope.user != null && sessionScope.user.roleUtilisateur == 'tuteur'}">
                    <a href="welcome-tuteur">Ma liste d'apprentis</a>
                </c:when>
            </c:choose>
        </div>
        <div>
        <c:choose>
            <c:when test="${sessionScope.user != null}">
                Bonjour ${sessionScope.user.personne.prenom}&nbsp;${sessionScope.user.personne.nom}&nbsp;|&nbsp;
                <a href="deconnexion">Se déconnecter</a>
            </c:when>
            <c:otherwise>
                <div>Non connecté</div>
            </c:otherwise>
        </c:choose>
        </div>
    </div>
</div>

<div class="content" id="general-content">
