
<%@ include file="header.jsp"%>

<h1>Informations apprenti</h1>
<form action="" method="post" class="container card bordered" id="container-form-apprentis_infos">
    <table class="tutorat-table tutorat-table-form">
        <tr>
            <td><label for="nom">Nom</label></td>
            <td><input type="text" name="nom" id="nom" disabled/></td>
        </tr>
        <tr>
            <td><label for="prenom">Prénom</label></td>
            <td><input type="text" name="prenom" id="prenom" disabled/></td>
        </tr>
        <tr>
            <td><label for="anneeAcademique">Année academique</label></td>
            <td><input type="text" name="anneeAcademique" id="anneeAcademique" disabled/></td>
        </tr>
        <tr>
            <td><label for="majeure">Majeure</label></td>
            <td><input type="text" name="majeure" id="majeure" disabled/></td>
        </tr>
        <tr>
            <td><label for="entreprise">Entreprise</label></td>
            <td>
                <select name="entreprise" id="entreprise" disabled>
                    <option value="">Choisir une entreprise</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="maitreApprentissage">Maître d'apprentissage</label></td>
            <td>
                <select name="maitreApprentissage" id="maitreApprentissage" disabled>
                    <option value="">Choisir un MA</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="tuteur">Tuteur</label></td>
            <td>
                <select name="tuteur" id="tuteur" disabled>
                    <option value="">Choisir un tuteur</option>
                </select>
            </td>
        </tr>
    </table>
    <div class="container-button">
        <button type="submit" disabled>Valider</button>
    </div>
</form>

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

<%@ include file="footer.jsp"%>