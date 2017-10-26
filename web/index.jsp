<%@ page import="tools.Functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>IdeaNoval</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
  </head>
  <body>
  <jsp:include page="header.jsp"></jsp:include>
  <%=Functions.debug(session)%>
  </body>
</html>
