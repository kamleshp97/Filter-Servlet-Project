<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<style type="text/css">
	.productImgage{
		height: 250px !important;
	    width: 460x !important;
	}
	.badge{
		top: -11px !important;
		font-size: 11px;
	}
	
</style>
</head>
<body>

<% 
String email = (String) session.getAttribute("EMAIL"); 
Boolean isLoginPass = (Boolean) session.getAttribute("isLoginPass");
%>

<c:set var="LENGTH" value="${fn:length(PRODUCTS)}"></c:set>
<div>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	   <a class="navbar-brand" href="homepage">
	    <img src="https://png.pngtree.com/png-clipart/20200709/original/pngtree-initial-letter-kp-logo-template-png-image_3580344.jpg" width="30" height="30" class="d-inline-block align-top" alt="not found">
	   		KP Mobile Shop
	  </a>	  
	  <div class="collapse navbar-collapse" id="navbarNavAltMarkup" style = "float:right;">
	    <div class="navbar-nav" style="padding-left: 1100px;">
	      <a class="nav-link active" href="mainPage">Products<span class="sr-only">(current)</span></a>
	     
      		<form method="post" action="checkoutProduct">
      			<input type="text" style="display: none;" name="emailBy" value="${EMAILBY}">
		        <button class = "btn" data-toggle="tooltip" data-placement="bottom" title="Move to basket" type ="submit" name="actionType">
			        <i class="fa-solid fa-cart-shopping text-white" style="font-size: large"></i>
			  		<span class="badge badge-warning">${TOTALPRODUCTQUANTITY}</span>
			  		<span class="sr-only">unread messages</span>
		  		</button>	
		    </form>
		  <% if(isLoginPass){ %>
	      	<a class="nav-link" data-toggle="tooltip" data-placement="bottom" title="Logout" href="logout" style="font-size: x-large"><i class="fa-solid fa-power-off text-white"></i></a>
	      <% } %>
	    </div>
	  </div>
	</nav>
	<div>
		<h1 class="text-center m-4">Products</h1>
	</div>
	<div>
		<div class="row row-cols-1 row-cols-md-5 m-2">
			<c:if test="${LENGTH > 0 }">
			<c:forEach var="i" begin="0" end="${fn:length(PRODUCTS)-1 }">
			<c:set var="PROD" value="${PRODUCTS[i]}"></c:set>		
			  <div class="col mb-3">
			    <div class="card h-100 shadow-lg p-3 rounded">
			      <img src="${PROD.PRODUCTIMAGEURL}" class="card-img-top productImgage" alt="Image not loading ..">
			      <div class="card-body">
			        <h5 class="card-title">${PROD.PRODUCTRITLE}</h5>
			        <h6 class="card-text">Price: Rs. ${PROD.PRODUCTPRICE}</h6>
			        <form method="post" action="checkoutProduct">
			        <input type="text" style="display: none;" name="productId" value="${PROD.PRODUCTID}">
			        <input type="text" style="display: none;" name="emailBy" value="${EMAILBY}">
			        <input type="text" style="display: none;" name="productPrice" value="${PROD.PRODUCTPRICE}">
			        <input class = "btn bg-success text-white rounded-pill mt-2" name="actionType" type ="submit" value="Buy" />
			        <input class = "btn bg-warning rounded-pill ml-2 mt-2" type ="submit" name="actionType" value="Basket" />
			        </form>
			      </div>
			    </div>
			  </div>
			</c:forEach>
			</c:if>
		</div>
	</div>
	<footer class="bg-dark text-white mt-4  text-center">Connect me at kamleshp097@gmail.com</footer>
</div>
</body>
</html>