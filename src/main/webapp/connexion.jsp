<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" %>
<h1>Connexion</h1>
<form action="connexion" method="post" class="container card bordered">
    <table class="tutorat-table-form">
        <tr>
            <td><label for="nomUtilisateur">Login</label></td>
            <td><input type="text" name="nomUtilisateur" id="nomUtilisateur"/></td>
        </tr>
        <tr>
            <td><label for="motDePasse">Password</label></td>
            <td><input type="password" name="motDePasse" id="motDePasse"/></td>
        </tr>
    </table>
    <div class="container-button">
        <button>Valider</button>
    </div>
    <c:choose>
        <c:when test="${message_error != null}">
            ${message_error}
        </c:when>
    </c:choose>
</form>
<script>
    /*$(document).ready(()=>{
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
    });*/
</script>

<%@ include file="footer.jsp"%>