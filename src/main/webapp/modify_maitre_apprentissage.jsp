<%@ page import="com.efrei.projetfinal.model.MaitreApprentissageEntity, com.efrei.projetfinal.model.EntrepriseEntity" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp" %>

<h1>Modify Maitre d'Apprentissage</h1>
<div class="container card bordered" id="container-form-modify-maitre">
  <form action="${pageContext.request.contextPath}/modify-maitre-apprentissage/${maitre.idPersonne}" method="post">
    <div class="form-group">
      <label for="nom">Name:</label>
      <input type="text" id="nom" name="nom" value="${maitre.personne.nom}" required>
    </div>
    <div class="form-group">
      <label for="prenom">Surname:</label>
      <input type="text" id="prenom" name="prenom" value="${maitre.personne.prenom}" required>
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" id="email" name="email" value="${maitre.personne.adresseElectronique}" required>
    </div>
    <div class="form-group">
      <label for="telephone">Telephone:</label>
      <input type="text" id="telephone" name="telephone" value="${maitre.personne.telephone}" required>
    </div>
    <div class="form-group">
      <label for="poste">Poste:</label>
      <input type="text" id="poste" name="poste" value="${maitre.poste}" required>
    </div>
    <div class="form-group">
      <label for="entreprise">Company:</label>
      <select id="entreprise" name="entreprise" required>
        <% for(EntrepriseEntity entreprise : (List<EntrepriseEntity>)request.getAttribute("entreprises")) { %>
        <option value="<%= entreprise.getId() %>"><%= entreprise.getRaisonSociale() %></option>
        <% } %>
      </select>
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-primary">Update Maitre</button>
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
      alert('Maitre d\'Apprentissage update succeeded!');
    } else if ("<%= updateStatus %>" === "failure") {
      alert('Maitre d\'Apprentissage update failed!');
    }
  };
</script>
<%
  }
%>
