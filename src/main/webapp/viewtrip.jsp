<%@ page import="org.payaneh.repositories.TripRepository" %>
<%@ page import="org.payaneh.entities.Trip" %>
<%@ page import="java.util.List" %>


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
        +buyLink(id)+
         "           </td>\n" +
         "        </tr>";

        }
    %>
    <!--
    <script language="JavaScript">
        function setId(id){
            document.getElementById("tripID").value=id;
        }
    </script>
    -->
    <%!
        public String buyLink(int id) {
        return "<a href='finalbuy.jsp?tripId="+id+"' ><input type=\"submit\" value=\"buy\" " +
                " ></a>";
        }

    %>


    <%

        TripRepository tripRepo=TripRepository.getTripRepo();

                String origin=request.getParameter("origin");
                String destination=request.getParameter("destination");
                String date= request.getParameter("date");
                List<Trip> trips= tripRepo.findAll(origin,destination, date);

    %>
    <%=origin+" "+destination+""+date%>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th width="60%">way: <%=origin%> - <%=destination%></th>
                <th width="40%">Moving Date:<%=date%> </th>
            </tr>


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
                    for (int i=0;i<trips.size();i++){
                        Trip trip=trips.get(i);
                        out.println(
                                createRow(
                                        trip.getId(),
                                        trip.getDestination(),
                                        trip.getOrigin(),
                                        trip.getTripTime()));
                    }

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
