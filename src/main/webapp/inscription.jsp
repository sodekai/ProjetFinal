<%@ include file="header.jsp"%>

<h1>Connexion</h1>
<form action="inscription" method="post" class="container bordered">
    <div>
        <label for="nomUtilisateur">Login</label>
        <input type="text" name="nomUtilisateur" id="nomUtilisateur"/>
    </div>
    <div>
        <label for="motDePasse">Password</label>
        <input type="password" name="motDePasse" id="motDePasse"/>
    </div>
    <div>
        <label for="nom">Nom</label>
        <input type="text" name="nom" id="nom"/>
    </div>
    <div>
        <label for="prenom">Prénom</label>
        <input type="text" name="prenom" id="prenom"/>
    </div>
    <div>
        <label for="adresseElectronique">Adresse mail</label>
        <input type="text" name="adresseElectronique" id="adresseElectronique"/>
    </div>
    <div>
        <label for="telephone">Téléphone</label>
        <input type="text" name="telephone" id="telephone"/>
    </div>

    <div>
        <label for="apprenti">Apprenti</label>
        <input type="radio" name="apprenti" id="apprenti"/>

        <label for="tuteur">Tuteur</label>
        <input type="radio" name="tuteur" id="tuteur"/>
    </div>

    <button>S'inscrire</button>
</form>
<script>
    jQuery.onload(()=>{
        function ()=>{

        }
    });
</script>
<%@ include file="footer.jsp"%>