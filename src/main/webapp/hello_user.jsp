<%@ include file="header.jsp"%>

<c:choose>
    <c:when test="${session_user!=null}">
        Bonjour ${session_user}!
    </c:when>
    <c:otherwise>
        Aucun utilisateur connecté
    </c:otherwise>
</c:choose>

<%@ include file="footer.jsp"%>