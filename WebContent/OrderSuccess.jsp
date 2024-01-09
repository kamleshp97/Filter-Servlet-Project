<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>main</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<style type="text/css">
	.card {
	    display: flex;
	    flex-direction: row !important;
	    align-items: center !important;
		}
</style>
</head>
<body>

<% 
String email = (String) session.getAttribute("EMAIL"); 
Boolean isLoginPass = (Boolean) session.getAttribute("isLoginPass");
%>

<div>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	   <a class="navbar-brand" href="homepage">
	    <img src="https://png.pngtree.com/png-clipart/20200709/original/pngtree-initial-letter-kp-logo-template-png-image_3580344.jpg" width="30" height="30" class="d-inline-block align-top" alt="not found">
	   		KP Mobile Shop
	  </a>	  
	  <div class="collapse navbar-collapse" id="navbarNavAltMarkup" >
	    <div class="navbar-nav" style="padding-left: 900px;">
	      <a class="nav-link active" href="mainPage">Shopping<span class="sr-only">(current)</span></a>
	      <a class="nav-link" href="newProduct">Add New Product</a>
	    </div>
	  </div>
	</nav>
	<div>
		<h1 class="text-center m-2">Summary of order</h1>
	</div>
	<div>
		<h2 class="text-center text-success m-4">Order placed successfully. </h2>
	</div>
	<footer class="bg-dark text-white mt-4  text-center">Connect me at kamleshp097@gmail.com</footer>
</div>
</body>
</html>