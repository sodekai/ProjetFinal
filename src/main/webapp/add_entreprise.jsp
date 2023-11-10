<%@ page import="java.util.List" %>
<%@ page import="com.efrei.projetfinal.model.EntrepriseEntity" %>
<%@ include file="header.jsp" %>
<h1>Add a New Entreprise</h1>
<div class="container card bordered" id="container-form-add-entreprise">

  <form action="${pageContext.request.contextPath}/add-entreprise" method="post">
    <div class="form-group">
      <label for="raisonSociale">Raison Sociale:</label>
      <input type="text" id="raisonSociale" name="raisonSociale" required>
    </div>
    <div class="form-group">
      <label for="adresse">Adresse:</label>
      <input type="text" id="adresse" name="adresse" required>
    </div>
    <div class="form-group">
      <label for="informationsUtiles">Informations Utiles:</label>
      <input type="text" id="informationsUtiles" name="informationsUtiles">
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-primary">Add Entreprise</button>
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