<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
    <div>
        <form:form
            id="userForm"
            method="post"
            action="/mineral/inscription/send"
            modelAttribute="User">
            <p>
                <form:label path="username">Nom d'utilisateur </form:label>
                <form:input path="username"/>
            </p>

        </form:form>
    </div>
</body>
</html>
