<%@ page import="com.spring.henallux.firstSpringProject.model.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="./include/importTags.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<spring:url value='/css/catalog.css' />">
</head>
<body>
    <div class="col d-flex flex-column align-items-center justify-content-center">
        <%
            // Définir une liste en Java
            ArrayList<Category> items = (ArrayList<Category>) request.getAttribute("Categories");

            // Parcourir la liste avec une boucle for
            for (Category item : items) {
        %>
        <div class="row d-flex flex-column align-items-center justify-content-center">
            <%=  pageContext.getRequest().getLocale().getLanguage().equals("fr") ? item.getCategoryTranslations().get(1) : item.getCategoryTranslations().get(2) %>
        </div>
        <%
            } // Fin de la boucle
        %>
    </div>
</body>
</html>
