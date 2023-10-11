<%@ include file="header.jsp"%>

<h1>Connexion</h1>
<form action="connexion" method="post" class="container bordered">
    <div>
        <label for="nomUtilisateur">Login</label>
        <input type="text" name="nomUtilisateur" id="nomUtilisateur"/>
    </div>
    <div>
        <label for="motDePasse">Password</label>
        <input type="password" name="motDePasse" id="motDePasse"/>
    </div>
    <button>Valider</button>
</form>
<script>
    $(document).ready(()=>{
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: '/tutoratApprentis/api/apprenti/1',
            success: (response)=>{
                console.log(response);
            },
            error: (response)=>{
                console.log(response);
            }
        })
    });
</script>

<%@ include file="footer.jsp"%>