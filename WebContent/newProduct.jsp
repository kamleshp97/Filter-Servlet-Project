<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product Form</title>
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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	   <a class="navbar-brand" href="homepage">
	    <img src="https://png.pngtree.com/png-clipart/20200709/original/pngtree-initial-letter-kp-logo-template-png-image_3580344.jpg" width="30" height="30" class="d-inline-block align-top" alt="not found">
	   		KP Mobile Shop
	  </a>	  
	  <div class="collapse navbar-collapse" id="navbarNavAltMarkup" >
	    <div class="navbar-nav" style="padding-left: 900px;">
	      <a class="nav-link " href="mainPage">Shopping <span class="sr-only">(current)</span></a>
	      <a class="nav-link active" href="about">Add New Product</a>
	    </div>
	  </div>
	</nav>
	<h1 class="text-center m-2">New Product Form</h1>
	<div class="divMargin">
		<form method="post" action="addNewProduct" enctype="multipart/form-data">
		<div class="form-group">
		      <label for="category">Product Category</label>
		      <select id="category" name="category" class="form-control" required>
		        <option>Choose Mobile Brand</option>
		        <option>Apple</option>
		        <option>Samsung</option>
		        <option>Realme</option>
		      </select>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputEmail1">Product Title</label>
		    <input type="text" class="form-control" id="title" name="title" required>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Product Description</label>
		    <input type="text" class="form-control" id="description" name="description" required>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPrice1">Product Price</label>
		    <input type="number" class="form-control" id="price" name="price" required>
		  </div>
		  <div class="form-group">
		      <label for="quantity">Product Quantity</label>
		      <select id="quantity" name="quantity" class="form-control" required>
		        <option selected>1</option>
		        <option>2</option>
		        <option>3</option>
		        <option>4</option>
		        <option>5</option>
		      </select>
		  </div>
		   <div class="form-group">
		    <label for="exampleFormControlFile1">Upload Product Image</label>
		    <input type="file" class="form-control-file" id="image" name="image">
		  </div>
		
		  <input type="submit" class="btn btn-primary" value="Add Product" />
		</form>
	</div>
	<footer class="bg-dark text-white mt-4  text-center">Connect me at kamleshp097@gmail.com</footer>
</div>
</body>
</html>