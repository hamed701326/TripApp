<%@ page import="org.payaneh.repositories.TripRepository" %>
<%@ page import="org.payaneh.entities.Trip" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hamed Sadeghi
  Date: 1/31/2020
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trips</title>
    <link rel="stylesheet" href="viewtrip.css">
</head>
<body>
    <%!
        public String createRow( int id,String destination,String origin,String time) {
             return
                     "        <tr>\n"+
        "            <th >" +id+ "</th>\n" +
        "            <td >"+destination+"</td>\n" +
        "            <td>" +origin+ "</td>\n" +
        "            <td >"+time+"</td>\n" +
        "           <td>\n"
        +buyLink()+
         "           </td>\n" +
         "        </tr>";

        }
    %>
    <%!

        public String buyLink() {
         return "<a href='finalbuy.jsp'>buy</a>";

    }

    %>

    <%

        TripRepository tripRepo=TripRepository.getTripRepo();

                String origin=request.getParameter("origin");
                String destination=request.getParameter("destination");
                String date= request.getParameter("date");
                List<Trip> trips= tripRepo.findAll(origin,destination, date);

    %>
    <div>Ticket at this date <%=date%></div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">destination</th>
                <th scope="col">origin</th>
                <th scope="col">time</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody id="table-body">
                 <%
                  out.println(   createRow(1,
                             "tehran",
                             "mashad",
                             "2020/1/30")
                     ) ;
                 %>
            </tbody>
        </table>
    </div>
    <!--
    trips.forEach(trip -> out.println(createRow(trip.getId(),
    trip.getDestination(),
    trip.getOrigin(),
    trip.getTripTime())));
    -->

</body>
</html>
