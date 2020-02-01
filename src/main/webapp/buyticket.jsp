<%@ page import="java.util.Date" %>
<%@ page import="org.payaneh.repositories.TicketRepository" %>
<%@ page import="org.payaneh.repositories.TripRepository" %>
<%@ page import="org.payaneh.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body style="display: flex;
    background: url(images.jpg);
    background-size: cover;">
<%
    User user= (User) session.getAttribute("user");
%>
    <%=user.getUserName()%>
<div >
    <form action="viewtrip.jsp">
        <datalist id="cities">
            <option value="tehran">
            <option value="kashan">
            <option value="esfehan"><option value="shiraz"><option value="tabriz">
            <option value="kerman"><option value="hormozgan">
        </datalist>

        Origin:<input list="cities" name="origin" placeholder="kerman" required="required">


        Destination <input list="cities" name="destination" placeholder="tehran" required="required">

        Date:<input type="date" name="date" min=<%=new Date()%>><br><br>

        <input type="submit" name="" value="search">
    </form>


</div>
</body>