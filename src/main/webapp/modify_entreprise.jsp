<%@ page import="com.efrei.projetfinal.model.EntrepriseEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ include file="header.jsp" %>
<h1>Modify Entreprise</h1>
<div class="container card bordered" id="container-form-modify-entreprise">

    <form action="${pageContext.request.contextPath}/modify-entreprise/${entreprise.id}" method="post">
    <div class="form-group">
            <label for="raisonSociale">Raison Sociale:</label>
            <input type="text" id="raisonSociale" name="raisonSociale" value="${entreprise.raisonSociale}" required>
        </div>
        <div class="form-group">
            <label for="adresse">Adresse:</label>
            <input type="text" id="adresse" name="adresse" value="${entreprise.adresse}" required>
        </div>
        <div class="form-group">
            <label for="informationsUtiles">Informations Utiles:</label>
            <input type="text" id="informationsUtiles" name="informationsUtiles" value="${entreprise.informationsUtiles}">
        </div>
        <div class="form-group">

            <button type="submit" class="btn btn-primary">Update Entreprise</button>
        </div>
    </form>
</div>

<%@ include file="footer.jsp" %>

<%
    String updateStatus = request.getParameter("updateStatus");
    if (updateStatus != null) {
%>
<script>
    window.onload = function() {
        if ("<%= updateStatus %>" === "success") {
            alert('Update succeeded!');
        } else if ("<%= updateStatus %>" === "failure") {
            alert('Update failed!');
        }
    };
</script>
<%
    }
%>
