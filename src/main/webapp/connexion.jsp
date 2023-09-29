<%@ include file="header.jsp"%>

<h1>Connexion</h1>
<form action="./connexion" method="get" class="container bordered">
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