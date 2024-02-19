<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
    <%@ page import="com.revengers.team.encapsulated.ALEntity" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AirLine Poilcy</title>
</head>
<style>
header{
background-color: wheat;
color: #7b312d;
font-weight: bold;
margin-top:  0;
margin-bottom: 0;
padding: 20px;
font-size: 45px;
text-shadow: 2px 2px 4px  rgba(0, 0, 0, 0.5); 
display: flex;
align-items: center; 
justify-content: center;
box-shadow: 2px 2px 4px rgba(0, 0, 0, 1.5);
}
header img {
  margin-right: 20px;
  height: 70px;
}
body{
margin: 0;
padding: 0;
background-color: #7b312d;
font-family: Arial, sans-serif;
} 
.bill {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: wheat;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
.bill form {
    display: grid;
}

.bill label {
    font-weight: bold;
    color: #7b312d;
}
.bill input[type="text"] {
    width: auto;
    padding: 10px;
    border: 1px solid white;
    border-radius: 5px;  
    color: black;
    font-weight: bold;
}
.bill input[type="submit"] {
    padding: 10px 20px;
    background-color: #7b312d;
    color: wheat;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
h2{
  color: #7b312d;
  text-shadow: 2px 2px 4px  rgba(0, 0, 0, 0.5); 
}

</style>
<body>
<header>
    <img src="https://ih1.redbubble.net/image.457170105.5964/st,small,507x507-pad,600x600,f8f8f8.jpg" alt="">
    REVENGERS VEHICLE INSURANCE
</header>
<br>
    <div class="bill">
        <h2>Policy Details & Billing Details:</h2>
        <form action="index.jsp" method="post">
<table>
<%
Object obj = session.getAttribute("details2");
if(obj == null){
	out.print("No records found :");
}else{
	List<Entity> entity = (ArrayList<Entity>) obj;	
%>
<tr>
<th>SNo: </th><th>Name: </th><th>Age:</th><th>PolicyNo: </th><th>StartDate: </th><th>EndDate: </th></tr>
<%
for(Entity enrol : entity){
%>
<tr>
<td><%=enrol.getSNo() %></td><td><%=enrol.getName()%></td><td><%= enrol.getAge()%></td><td><%=enrol.getPolicyNo()%></td><td><%=enrol.getStartDate()%></td><td><%=enrol.getEndDate()%></td></tr>
<% } } %>
</table>
            <input type="submit" value="Back to Homepage">
        </form>
    </div>

</body>
</html>