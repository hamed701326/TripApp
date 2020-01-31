<%@ page import="org.payaneh.repositories.TripRepository" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.Console" %><%--
  Created by IntelliJ IDEA.
  User: Hamed Sadeghi
  Date: 1/31/2020
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        TripRepository tripRepo=TripRepository.getTripRepo();

                String origin=request.getParameter("origin");
                String destination=request.getParameter("destination");
                String date= request.getParameter("date");
                tripRepo.findAll(origin,destination,(Date) date)
    %>


</body>
</html>
