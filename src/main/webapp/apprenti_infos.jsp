<%@ page import="com.efrei.projetfinal.model.EntrepriseEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.efrei.projetfinal.model.MaitreApprentissageEntity" %>
<%@ page import="com.efrei.projetfinal.model.ApprentiEntity" %>
<%@ page import="com.efrei.projetfinal.model.TuteurEntity" %>
<%@ include file="header.jsp" %>

<h1>Informations apprenti</h1>
<form action="" method="post" class="container card bordered" id="container-form-apprentis_infos">
    <table class="tutorat-table tutorat-table-form">
        <tr>
            <td><label for="nom">Nom</label></td>
            <td id="nomText">${apprenti.utilisateur.personne.nom}</td>
            <td id="nomInput" style="display:none;"><input type="text" name="nom" id="nom" value="${apprenti.utilisateur.personne.nom}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><label for="prenom">Prénom</label></td>
            <td id="prenomText">${apprenti.utilisateur.personne.prenom}</td>
            <td id="prenomInput" style="display:none;"><input type="text" name="prenom" id="prenom" value="${apprenti.utilisateur.personne.prenom}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><label for="anneeAcademique">Année academique</label></td>
            <td id="anneeAcademiqueText">${apprenti.anneeAcademique}</td>
            <td id="anneeAcademiqueInput" style="display:none;"><input type="text" name="anneeAcademique" id="anneeAcademique" value="${apprenti.anneeAcademique}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><label for="majeure">Majeure</label></td>
            <td id="majeureText">${apprenti.majeure}</td>
            <td id="majeureInput" style="display:none;"><input type="text" name="majeure" id="majeure" value="${apprenti.majeure}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><label for="tuteur">Tuteur</label></td>
            <td id="tuteurText">${apprenti.tuteur.utilisateur.personne.nom} ${apprenti.tuteur.utilisateur.personne.prenom}</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><label for="entreprise">Entreprise</label></td>
            <td id="entrepriseText">${apprenti.entreprise.raisonSociale}</td>
            <td id="entrepriseInput" style="display:none;">
                <select name="entreprise" id="entreprise" onchange="updateModifyButtonUrl(this.value)">
                    <%
                        ApprentiEntity apprenti = (ApprentiEntity) request.getAttribute("apprenti");
                        List<EntrepriseEntity> entreprises = (List<EntrepriseEntity>) request.getAttribute("entreprises");
                        for(EntrepriseEntity entreprise : entreprises) {
                            String selected = entreprise.getId() == apprenti.getEntreprise().getId() ? "selected" : "";
                    %>
                    <option value="<%= entreprise.getId() %>" <%= selected %>><%= entreprise.getRaisonSociale() %></option>
                    <%
                        }
                    %>
                </select>
            </td>
            <td>
                <button style="display:none;" type="button" onclick="window.location.href='<%= request.getContextPath() %>/add-entreprise';" class="addEntrepriseButton">add</button>
            </td>
            <td>
                <button type="button" class="editEntrepriseButton" style="display:none;">modify</button>
            </td>
        </tr>
        <tr>
            <td><label for="maitreApprentissage">Maître d'apprentissage</label></td>
            <td id="maitreApprentissageText">${apprenti.maitreApprentissage.personne.nom} ${apprenti.maitreApprentissage.personne.prenom}</td>
            <td id="maitreApprentissageInput" style="display:none;">
                <select name="maitreApprentissage" id="maitreApprentissage">
                    <%
                        List<MaitreApprentissageEntity> maitresApprentissage = (List<MaitreApprentissageEntity>) request.getAttribute("maitresApprentissage");
                        for(MaitreApprentissageEntity maitreApprentissage : maitresApprentissage) {
                            String selected = maitreApprentissage.getId() == apprenti.getMaitreApprentissage().getId() ? "selected" : "";
                    %>
                    <option value="<%= maitreApprentissage.getId() %>" <%= selected %>><%= maitreApprentissage.getPersonne().getNom() %> <%= maitreApprentissage.getPersonne().getPrenom() %></option>
                    <%
                        }
                    %>
                </select>
            </td>
            <td>
                <button style="display:none;" type="button" onclick="window.location.href='<%= request.getContextPath() %>/add-maitre-apprentissage';" class="addMaitreButton">add</button>
            </td>
            <td> <button style="display:none;" class="editMaitreButton">modify</button> </td>
        </tr>
    </table>

    <div class="container-button">
        <button type="button" id="modifyButton" onclick="toggleEdit()">Modify</button>
        <button type="submit" id="applyButton" style="display: none;">Apply</button>
        <button type="button" id="cancelButton" onclick="cancelChanges()" style="display: none;">Cancel</button>
    </div>
</form>

<%@ include file="footer.jsp" %>



<script>
    function toggleEdit() {
        var isReadOnly = document.getElementById('modifyButton').style.display !== 'none';


        document.querySelectorAll('.tutorat-table td').forEach(function(element) {
            if (element.id.endsWith('Text') && element.id !== 'tuteurText') {
                element.style.display = isReadOnly ? 'none' : '';
            } else if (element.id.endsWith('Input')) {
                element.style.display = isReadOnly ? '' : 'none';
            }
        });

        document.getElementById('modifyButton').style.display = isReadOnly ? 'none' : '';
        document.getElementById('applyButton').style.display = isReadOnly ? '' : 'none';
        document.getElementById('cancelButton').style.display = isReadOnly ? '' : 'none';

        document.querySelectorAll('button').forEach(function(button) {
            if (button.textContent === 'add' || button.textContent === 'modify') {
                button.style.display = isReadOnly ? '' : 'none';
            }
        });
    }

    function cancelChanges() {
        toggleEdit();
    }

    function updateModifyButtonUrl(entrepriseId) {
        var modifyButton = document.querySelector('.editEntrepriseButton');
        var modifyUrl = '<%= request.getContextPath() %>/modify-entreprise/' + entrepriseId;
        modifyButton.onclick = function() {
            window.location.href = modifyUrl;
        };
    }

</script>

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

<script>
    /*
    $(document).ready(()=>{
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: '/tutoratApprentis/api/apprenti/1',
            success: (response)=>{
                console.log(response);
                if(response.length > 0){
                    $('#anneeAcademique').val(response.anneeAcademique);
                    $('#entreprise').val(response.entreprise.raisonSociale);
                    $('#maitreApprentissage').val(response.maitreApprentissage.personne.nom+" "+response.maitreApprentissage.personne.prenom);

                }
            },
            error: (response)=>{
                console.log(response);
            }
        })
    });*/
</script>

