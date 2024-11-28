<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="<spring:url value='/css/template.css' />"/>
    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr"/>
    </spring:url>
    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en"/>
    </spring:url>
</head>
<body class="d-flex flex-column min-vh-100">
    <div id="header" class="row align-items-start">
        <div class="col text-center d-flex align-items-center justify-content-center">
            <div class="col text-center d-flex align-items-center justify-content-center">
                <a href="<spring:url value='/home' />">
                    <spring:message code="homePage"/>
                </a>
            </div>
            <div class="col text-center d-flex align-items-center justify-content-center">
                <a href="${localeFr}">
                    <img alt="fr" src='<spring:url value="/images/flag_fr.png"/>' />
                </a>
                <a href="${localeEn}">
                    <img alt="en" src='<spring:url value="/images/flag_en.png"/>' />
                </a>
            </div>
        </div>
        <div class="col text-center d-flex align-items-center justify-content-center">
            <div class="col text-center d-flex align-items-center justify-content-center">
                <p><spring:message code="welcomeMessage"/></p>
            </div>
        </div>
        <div class="col text-center d-flex align-items-center justify-content-center">
            <sec:authorize access="!isAuthenticated()">
                <div>
                    <a href="<spring:url value='/inscription' />">
                        s'inscrire
                    </a>
                </div>
                <div>
                    <a href="<spring:url value='/login' />">
                        se connecter
                    </a>
                </div>

            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a href="<spring:url value='/logout' />">
                    se déconnecter
                </a>
            </sec:authorize>
        </div>

    </div>

    <div id="content" class="row flex-fill">
      <tiles:insertAttribute name="main-content"/>
    </div>

    <div id="footer" class="row align-items-end">
        <div class="col text-center d-flex align-items-center justify-content-center">
            <a href="<spring:url value='/html/informations.html' />">
                <spring:message code="companyInfos"/>
            </a>
        </div>
    </div>
</body>
</html>
