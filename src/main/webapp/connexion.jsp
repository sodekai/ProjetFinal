<%--
  Created by IntelliJ IDEA.
  User: minos
  Date: 28/09/2023
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1>Connexion</h1>
<form action="./connexion" method="get" class="content cadre" id="cadre-connexion">
    <div>
        <label for="login">Login</label>
        <input type="text" name="login" id="login" />
    </div>
    <div>
        <label for="mdp">Password</label>
        <input type="password" name="mdp" id="mdp" />
    </div>
    <button>Valider</button>
</form>

<%@ include file="footer.jsp"%>