<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:choose>
    <c:when test="${session.user!=null}">
        Bonjour ${session.user}!
    </c:when>
    <c:otherwise>
        Aucun utilisateur connecté
    </c:otherwise>
</c:choose>

<%@ include file="footer.jsp"%>