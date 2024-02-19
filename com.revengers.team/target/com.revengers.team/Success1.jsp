<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.revengers.team.encapsulated.InsuranceEntity" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page Claim</title>
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
    max-width: 700px;
    margin: 20px auto;
    padding: 20px;
    background-color: wheat;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.bill form label {
    display: grid;
    font-weight: bold;
    color: #7b312d;
    margin-bottom: 10px;
}
.bill input[type="text"] {
    width: 100%;
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
    <h2>Claim Status:</h2>
    <label>Policy Number:</label>
    <input type="text" name="policy_no" value="${insuranceClaim.policy_no}" readonly><br>

    <label>Customer ID:</label>
    <input type="text" name="customer_id" value="${insuranceClaim.customer_id}" readonly><br>

    <label>Policy Type:</label>
    <input type="text" name="policy_type" value="${insuranceClaim.policy_type}" readonly><br>

    <label>Damage On:</label>
    <input type="text" name="damage_on" value="${insuranceClaim.damage_on}" readonly><br>
    
    <label>Bill Amount:</label>
    <input type="text" name="bill_amount" value="${insuranceClaim.bill_amount}/-" readonly><br>

    <label>Claimed Amount:</label>
    <input type="text" name="claim_amount" value="${claim_amount}/-" readonly><br>

    <form action="index.jsp" method="post">
        <input type="submit" value="Back to Homepage">
    </form>
</div>
</body>
</html>