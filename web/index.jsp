<%@ page import="tools.Functions" %>
<%@ page import="db.Database" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Connection db = Database.getInstance(); %>
<html>
<head>
    <title>IdeaNoval</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%=Functions.debug(session)%>
<main class="container">
    <h1 class="text-center">Liste des dernières idées parues !</h1>
    <div class="row">
        <div class="col-md-6 col-md-offset-3 col-xs-10 col-xs-offset-1">

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Catégorie</th>
        </tr>
        </thead>
        <tbody>
        <%
            try {
                Statement st = db.createStatement();
                ResultSet rs = st.executeQuery("select title, pseudo, name from idea natural join user natural join category; ");

                while(rs.next())
                {
                    %>
             <td><%=rs.getString("title")%></td>
             <td><%=rs.getString("pseudo")%></td>
              <td><%=rs.getString("name")%></td>

                 <% }
            } catch (SQLException e) {
                out.print(e.getMessage());
            }
        %>
        </tbody>
    </table>
        </div>
    </div>
</main>

<script src="js/jquery-3.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/header.js"></script>
</body>
</html>
