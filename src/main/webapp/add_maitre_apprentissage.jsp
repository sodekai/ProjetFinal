<%@ page import="java.util.List" %>
<%@ page import="com.efrei.projetfinal.model.EntrepriseEntity" %>
<%@ include file="header.jsp" %>

<h1>Add a New Maitre d'Apprentissage</h1>
<div class="container card bordered" id="container-form-add-maitre">
    <form action="${pageContext.request.contextPath}/add-maitre-apprentissage" method="post">
        <div class="form-group">
            <label for="nom">Name:</label>
            <input type="text" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="prenom">Surname:</label>
            <input type="text" id="prenom" name="prenom" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="telephone">Telephone:</label>
            <input type="text" id="telephone" name="telephone" required>
        </div>
        <div class="form-group">
            <label for="poste">Poste:</label>
            <input type="text" id="poste" name="poste" required>
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
            <button type="submit" class="btn btn-primary">Add Maitre</button>
        </div>
    </form>
</div>

<%@ include file="footer.jsp" %>

<%
    String status = request.getParameter("status");
    if ("success".equals(status)) {
%>
<script>alert('Maitre d\'Apprentissage added successfully!');</script>
<%
} else if ("failure".equals(status)) {
%>
<script>alert('Failed to add Maitre d\'Apprentissage.');</script>
<%
    }
%>


