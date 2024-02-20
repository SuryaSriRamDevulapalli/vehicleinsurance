<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Claim Status</title>
</head>

<style>
.bottom-bar {
    background-color: wheat;
    height: 70px;
    width: 100%;
    position: fixed;
    bottom: 0;
    left: 0;
} 
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
background-image: url("https://static.thenounproject.com/png/1513952-200.png");
background-repeat: no-repeat;
background-position: center;
		background-size:  20%;
		background-attachment: fixed;
		font-family: Arial, sans-serif;				
		margin: 0;
        padding: 0;
}

</style>
<body>
<header>
    <img src="https://ih1.redbubble.net/image.457170105.5964/st,small,507x507-pad,600x600,f8f8f8.jpg" alt="">
    REVENGERS VEHICLE INSURANCE
</header>

<h3 align="center" style="margin-top: 20px; color: wheat; font-size: 25px">Mail Sent Successfully!</h3>




<div class="bottom-bar">
<button onclick="window.location.href='mailbox.jsp';"style="font-size: 15px; padding: 10px 20px; background-color: #7b312d; color: wheat; border: none; border-radius: 5px; cursor: pointer;">Back to MailBox</button>
</div> 
</body>
</html>