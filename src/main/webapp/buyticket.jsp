<%@ page import="java.util.Date" %>
<%@ page import="org.payaneh.repositories.TicketRepository" %>
<%@ page import="org.payaneh.repositories.TripRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div style="display: flex;
    background: url(images.jpg);
    background-size: cover;">
    <form action="viewtrip.jsp">
    <div >
        Origin:<input type="text" name="origin">
    </div>
    <div>
        Destination <input type="text" name="destination">
    </div>
    <div>
        Date:<input type="date" name="date" min=<%=new Date()%>><br><br>
    </div>
        <input type="submit" name="" value="search">
    </form>

</div>
