<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
      <p>Header</p>
    </div>

    <div>
      <tiles:insertAttribute name="main-content"/>
    </div>

    <div>
      <p>Footer</p>
    </div>
</body>
</html>
