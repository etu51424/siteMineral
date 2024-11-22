<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Inscription</title>
    <link rel="stylesheet" type="text/css" href=href="<spring:url value='/css/userInscription.css' />">
</head>
<body>
    <div class="col text-center d-flex align-items-center justify-content-center">
        <form:form
            id="userForm"
            method="post"
            action="/mineral/inscription/send"
            modelAttribute="User">
            <p>
                <form:label path="username">Nom d'utilisateur </form:label>
                <form:input path="username"/>
            </p>
            <p>
                <form:label path="first_name">Prénom </form:label>
                <form:input path="first_name"/>
            </p>
            <p>
                <form:label path="last_name">Nom </form:label>
                <form:input path="last_name"/>
            </p>
            <p>
                <form:label path="address">adresse </form:label>
                <form:input path="address"/>
            </p>
            <p>
                <form:label path="phone_number">Numéro de téléphone </form:label>
                <form:input path="phone_number"/>
            </p>
            <p>
                <form:label path="gender">Sexe </form:label>
                <form:select path="gender">
                    <form:option value="M">Homme</form:option>
                    <form:option value="F">Femme</form:option>
                    <form:option value="X">Autre</form:option>
                </form:select>
            </p>
            <p>
                <form:label path="birth_date">Date de naissance </form:label>
                <form:input path="birth_date"/>
            </p>
            <p>
                <form:label path="password">Mot de passe </form:label>
                <form:input path="password"/>
            </p>
            <p>
                <form:button>Submit</form:button>
            </p>
        </form:form>
    </div>
</body>
</html>
