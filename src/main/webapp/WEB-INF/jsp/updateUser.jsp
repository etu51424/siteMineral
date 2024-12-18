<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
  <title>Inscription</title>
  <link rel="stylesheet" href="<spring:url value='/css/forms.css' />">

</head>
<body>
<div class="col d-flex flex-column align-items-center justify-content-center">
  <h2 class="row">
    Update form
  </h2>
  <div class="row">
    <form:form class="col d-flex flex-column align-items-center justify-content-center"
               id="userForm"
               method="POST"
               action="/mineral/update/send"
               modelAttribute="User">
      <p>
        <form:label path="firstName">
          <spring:message code="firstName"/>
        </form:label>
        <form:input path="firstName"/>
      </p>
      <p>
        <form:label path="lastName">
          <spring:message code="lastName"/>
        </form:label>
        <form:input path="lastName"/>
      </p>
      <p>
        <form:label path="address">
          <spring:message code="address"/>
        </form:label>
        <form:input path="address"/>
      </p>
      <p>
        <form:label path="email">
          <spring:message code="email"/>
        </form:label>
        <form:input type="email" path="email"/>
      </p>
      <p>
        <form:label path="phoneNumber">
          <spring:message code="phoneNumber"/>*
        </form:label>
        <form:input path="phoneNumber"/>
      </p>
      <p>
        <form:label path="gender">
          <spring:message code="gender"/>
        </form:label>
        <form:select path="gender">
          <form:option value="M">
            <spring:message code="genderM"/>
          </form:option>
          <form:option value="F">
            <spring:message code="genderF"/>
          </form:option>
          <form:option value="X">
            <spring:message code="genderX"/>
          </form:option>
          <form:option value="${null}">
            <spring:message code="unknowGender"/>
          </form:option>
        </form:select>
      </p>
      <p>
        <form:label path="birthDate">
          <spring:message code="birthDate"/>
        </form:label>
        <form:input path="birthDate" type="date" min="1900-01-01" max="${todayDate}" />
      </p>
      <p>
        <form:label path="password">
          <spring:message code="password"/>
        </form:label>
        <form:input type="password" path="password"/>

        <span class="error">
                <form:errors path="password">
                  <spring:message code="passwordLenghtError"/>
                </form:errors>
        </span>
      </p>
      <p>
        <form:label path="passwordConfirmation">
          <spring:message code="passwordConfirmation"/>
        </form:label>
        <form:input type="password" path="passwordConfirmation"/>

        <span class="error">
                <form:errors path="passwordConfirmation">
                  <spring:message code="passwordConfirmationError"/>
                </form:errors>
        </span>
      </p>
      <p>
        <form:button>
          <spring:message code="submitButton"/>
        </form:button>
      </p>
    </form:form>
  </div>
</div>
</body>
</html>

</body>
</html>
