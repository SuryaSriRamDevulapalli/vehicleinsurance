<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.revengers.team.encapsulated.InsuranceEntity" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page Enrollment</title>
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
            <label for="vehicle_name">Vehicle Name:</label>
            <input type="text" id="vehicle_name" name="vehicle_name" value="<%= request.getParameter("vehicle_name") %>" readonly ><br>

            <label for="variant">Variant:</label>
            <input type="text" id="variant" name="variant" value="<%= request.getParameter("variant") %>" readonly><br>

            <label for="fuel_type">Fuel Type:</label>
            <input type="text" id="fuel_type" name="fuel_type" value="<%= request.getParameter("fuel_type") %>" readonly><br>

            <label for="vehicle_no">Vehicle Number:</label>
            <input type="text" id="vehicle_no" name="vehicle_no" value="<%= request.getParameter("vehicle_no") %>" readonly ><br>

            <label for="policy_type">Policy Type:</label>
            <input type="text" id="policy_type" name="policy_type" value="<%= request.getParameter("policy_type") %>" readonly ><br>

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="<%= request.getParameter("name") %>" readonly ><br>

            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="<%= request.getParameter("email") %>" readonly><br>

            <label for="number">Number:</label>
            <input type="text" id="number" name="number" value="<%= request.getParameter("number") %>" readonly><br>

            <label for="pincode">PinCode:</label>
            <input type="text" id="pincode" name="pincode" value="<%= request.getParameter("pincode") %>" readonly><br>

            <label for="policyNumber">Policy Number:</label>
            <input type="text" id="policyNumber" name="policyNumber" value="<%= request.getAttribute("policyNumber") %>" readonly><br>

            <label for="customerID">Customer ID:</label>
            <input type="text" id="customerID" name="customerID" value="<%= request.getAttribute("customerID") %>" readonly><br>

            <label for="price">Price(Annually):</label>
            <input type="text" id="price" name="price" value="<%= request.getAttribute("price") %>/-" readonly><br>

            <input type="submit" value="Back to Homepage">
        </form>
    </div>

</body>
</html>