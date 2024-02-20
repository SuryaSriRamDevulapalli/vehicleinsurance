<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.NumberFormat" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Revengers Insurance Home Page</title>
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
nav ul li {
display: inline;
margin-right: 80px;
background-color: wheat;
font-size:30px;
padding: 10px;
border-radius: 5px;
box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }
nav ul li a {
color: #7b312d;
text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); 
text-decoration: none;
transition: color 0.3s ease;
        }
nav ul li:hover {
    background-color: white;
}  
.container {
display: flex;
padding: 10px 20px; 
background-color: wheat;
padding: 10px;
color: #7b312d;
font-size: 20px;
border-radius: 5px;
box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);       
        }
.feature {           
padding: 20px;
        } 
.feature.left img {
    height: 200px;
    width: auto;
}   
h2{
font-size: 30px;
margin-top: 0;
} 
 th, td {
            border: 3px solid black;
         	padding: 8px;
        	text-align: left;
        } 
        table{
        color: #7b312d;
        } 
h2{
text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); 
}        
              
</style>

<body>
<header>
    <img src="https://ih1.redbubble.net/image.457170105.5964/st,small,507x507-pad,600x600,f8f8f8.jpg" alt="">
    REVENGERS VEHICLE INSURANCE
</header>

<h1>
				<nav>
					<ul>
						<li><a href="newenrollment.jsp">New Enrollment</a></li>
						<li><a href="claimstatus.jsp">Claim Status</a></li>
						<li><a href="otherloans.jsp">Other Policies</a></li>
                        <li><a href="mailbox.jsp">MailBox</a></li>
                        <li><a href="myprofile.jsp">View Profile</a></li>
					</ul>
				</nav>
			</h1>

<div class="container">
<div>
			<article class="feature left">
			<img  src="https://ih1.redbubble.net/image.457170105.5964/st,small,507x507-pad,600x600,f8f8f8.jpg">
</article>			
</div>

<div>
<article class="feature right">
<p>Revengers Insurance is a private sector general insurance company in India.Founded in November 2016, the company received its license from the Insurance Regulatory and Development Authority of India (IRDAI) in September 2017.Revengers follows an online-led model and hence all operations for the company are offered through the digital platform.</p>
<p>Revengers Insurance was founded by Surya, is the Chief Executive Officer.As of 2018, Revengers has raised ₹274 crore ($42 million) in funding from investors such as Amazon, Accel Partners, SAIF Partners, Catamaran Ventures.The retail products offered by Revengers General Insurance include motor insurance, in-trip domestic insurance and mobile insurance.</p>
</article>
</div>
</div>
<br>

<div class="container">
<div>
			<article class="feature left">
			<h2>Personal Loan EMI Calculator:</h2>
<form>			
<table>
<tr>
<th>Loan Amount:</th>
<th><input type="text" name="loan"></th>
</tr>
<tr>
<th>Interest Rate:</th>
<th><input type="text" name="interest"></th>
</tr>
<tr>
<th>Tenure(months):</th>
<th><input type="text" name="tenure"></th>
</tr>
</table>
 <input type="submit" value="Calculate vamsi EMI" style="border: none; color:wheat; font-weight: bold; margin-top: 10px;padding: 5px 5px;background-color: #7b312d; border-radius: 5px;">
</form>
</article>			
</div>
<%
double Amount = 0;
double interest = 0;
double tenure = 0;

String loan = request.getParameter("loan");
if (loan != null && !loan.isEmpty()) {
    Amount = Double.parseDouble(loan);
}

String ini = request.getParameter("interest");
if (ini != null && !ini.isEmpty()) {
    interest = Double.parseDouble(ini) / 1200;
}

String ten = request.getParameter("tenure");
if (ten != null && !ten.isEmpty()) {
    tenure = Double.parseDouble(ten);
}

double emi = (Amount*interest*Math.pow((1+interest),tenure))/(Math.pow((1+interest),tenure) -1);

double totalPayment = emi * tenure;
double totalInterest = totalPayment - Amount;
%>
   <div class="emi-details">
        <article class="feature right">
            <h2>Loan Details:</h2>
<table>
<tr>
<th>Loan Amount:</th>
<td><%= Amount %>/-</td>
</tr>
<tr>
<th>Interest Rate:</th>
<td><%= interest*1200 %>%</td>
</tr>
<tr>
<th>Tenure(months):</th>
<td><%= tenure %></td>
</tr>

</table>
</article>
</div>
<div class="other-details">
        <article class="feature right">
            <h2>EMI Details:</h2>
            <table>
            <tr>
<th>EMI:</th>
<td><%= emi %>/-</td>
</tr>
<tr>
<th>Total Payment:</th>
<td><%= totalPayment %>/-</td>
</tr>
<tr>
<th>Total Interest:</th>
<td><%= totalInterest %>/-</td>
</tr>
</table>
        </article>
    </div>

</div>


</body>
</html>
