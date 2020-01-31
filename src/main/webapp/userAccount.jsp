<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.payaneh.entities.User" %>
<%@ page import="org.payaneh.repositories.TicketRepository" %>


<html>
<head>
    <%
        session=request.getSession(false);
        User user=(User)session.getAttribute("user");
    %>
    <title>
        <%=user.getFirstName()+" "+user.getLastName()%>
    </title>
</head>
<body >

    <h1>welcome to Payaneh</h1>
    <h2><%=user.getFirstName()+" "+user.getLastName()%> </h2>

    <!--buying ticket-->
    <% TicketRepository ticketRepo=TicketRepository.getTicketRep();

    %>
    <div class="menu">Buying Ticket</div>

    <div class="menu">View Tickets</div>



</body>
</html>
