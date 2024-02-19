<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
    <%@ page import="com.revengers.team.encapsulated.Entity" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medical Poilcy</title>
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
    REVENGERS MEDICAL INSURANCE
</header>
<br>
   <div class="bill">
    <h2>Medical Policy Details:</h2>
    <form action="otherloans.jsp" method="post">
        <%
        Object obj = session.getAttribute("details");
        if(obj == null){
            out.print("No records found :");
        } else {
            List<Entity> entity = (ArrayList<Entity>) obj;
            for(Entity enrol : entity){
        %>
        <label for="sno">Claim ID:</label>
        <input type="text" id="sno" name="sno" value="<%= enrol.getSNo() %>" readonly>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= enrol.getName() %>" readonly>

        <label for="age">Age:</label>
        <input type="text" id="age" name="age" value="<%= enrol.getAge() %>" readonly>

        <label for="policyNo">PolicyNo:</label>
        <input type="text" id="policyNo" name="policyNo" value="<%= enrol.getPolicyNo() %>" readonly>

        <label for="startDate">StartDate:</label>
        <input type="text" id="startDate" name="startDate" value="<%= enrol.getStartDate() %>" readonly>

        <label for="endDate">EndDate:</label>
        <input type="text" id="endDate" name="endDate" value="<%= enrol.getEndDate() %>" readonly>
        <% } }%>
            <input type="submit" value="Back to OtherLoans">
        </form>
    </div>

</body>
</html>