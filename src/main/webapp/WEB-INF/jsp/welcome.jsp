<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>
        <spring:message code="homePage"/>
    </title>

    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr"/>
    </spring:url>
    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en"/>
    </spring:url>
</head>
<body>
<div>
    <div>
        <a href="${localeFr}">
            <img alt="fr" src='<spring:url value="/images/flag_fr.png"/>' />
        </a>
        <a href="${localeEn}">
            <img alt="en" src='<spring:url value="/images/flag_en.png"/>' />
        </a>
    </div>
    <spring:message code="welcomeMessage"/>
</div>

</body>
</html>