<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Gateway</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<style type="text/css">
	.divMargin{
		margin: 50px;
	}
</style>
</head>
<body>
<div>
	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	   <a class="navbar-brand" href="homepage">
	    <img src="https://w7.pngwing.com/pngs/953/232/png-transparent-payment-gateway-computer-icons-e-commerce-payment-system-payment-blue-text-service-thumbnail.png" width="30" height="30" class="d-inline-block align-top" alt="not found">
	   		Payment Gateway
	  </a>	  
	</nav>
	<h1 class="text-center m-2">Payment Gateway</h1>
	<div class="divMargin">
		<form method="post" action="payment">
		 <div class="form-group text-center">
		    <label for="exampleInputEmail1">Product Id: ${productId}</label> 
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp

		    <label for="exampleInputEmail1"><b>Product Price: INR ${productPrice} Only.</b></label>
		  </div>
		<div class="form-group">
		    <label for="exampleInputEmail1">Card holder name: </label>
		    <input type="text" class="form-control" id="cardHolderName" name="cardHolderName" required>
		  </div>
		<div class="form-group">
		      <label for="category">Payment Type: </label>
		      <select id="category" name="category" class="form-control" required>
		        <option>Card</option>
		      </select>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputEmail1">Card Number: </label>
		    <input type="text" class="form-control" id="credential" name="credential" required>
		  </div>
			<input type="text" style="display: none" id="productId" name="productId" value="${productId}">
			<input type="text" style="display: none" id="productPrice" name="productPrice" value="${productPrice}">

		  <input type="submit" class="btn btn-success" value="Pay" />
		</form>
	</div>
	<footer class="bg-success text-white mt-4 text-center">Connect me at kamleshp097@gmail.com</footer>
</div>
</body>
</html>