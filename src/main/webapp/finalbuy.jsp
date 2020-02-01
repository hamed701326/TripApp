<%@ page import="org.payaneh.entities.User" %>
<%@ page import="org.payaneh.entities.Ticket" %>
<%@ page import="org.payaneh.repositories.TripRepository" %>
<%@ page import="org.payaneh.repositories.TicketRepository" %>
<%@ page import="org.payaneh.entities.Trip" %><%--
  Created by IntelliJ IDEA.
  User: Hamed Sadeghi
  Date: 1/31/2020
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User user= (User) session.getAttribute("user");
        String s= (String) request.getParameter("tripId");

            Integer tripId = Integer.parseInt(s);
            TripRepository tripRepo = TripRepository.getTripRepo();
            TicketRepository ticketRepo = TicketRepository.getTicketRep();
            Trip trip = tripRepo.findById(tripId);

    %>

    tripID:<%=tripId%>
    <p>
       <% switch (user.getGender()){
            case "male":
                out.print("Mr. ");
                break;
            case "female":
                out.print("Ms. ");
                break;
        }
        %>

        <%=user.getFirstName()+" "+user.getLastName()%>
        ,Your Ticket's Shopping successfully done.<br/>

        <%
            Ticket ticket=new Ticket();
            if(true){

                ticket.setName(user.getFirstName()+" "+user.getLastName());
                ticket.setSex("male");
                ticket.setTrip(trip);
                ticket.setUser(user);

                ticketRepo.save(ticket);
            }

        %>
        Ticket Id:<%=ticket.getId()%>

    </p>

</body>
</html>
