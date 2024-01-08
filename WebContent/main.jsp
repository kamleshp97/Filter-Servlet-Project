<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>main</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

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
	   		KP
	  </a>	  
	  <div class="collapse navbar-collapse" id="navbarNavAltMarkup" >
	    <div class="navbar-nav" style="padding-left: 900px;">
	      <a class="nav-link active" href="homePage">Main <span class="sr-only">(current)</span></a>
	      <a class="nav-link" href="newProduct">Add New Product</a>
	      <% if(isLoginPass){ %>
	      <a class="nav-link" href="login">Logout</a>
	      <% } %>
	    </div>
	  </div>
	</nav>
	<div>
		<h1 class="text-center m-2">Main Page</h1>
		<h3><b>Hi, <%=email%> </b></b>After successful login you reach here...</h3>
	</div>
	<div>
		<div class="row row-cols-1 row-cols-md-3">
		  <div class="col mb-4">
		    <div class="card h-100">
		      <img src="data:image/jpeg;base64,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" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
		        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		      </div>
		    </div>
		  </div>
		  <div class="col mb-4">
		    <div class="card h-100">
		      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzNYDkqqk5Qbt603sKuQI8BzutfQNea-dY6Y5Z4Ern_1PeFVCDF3ix-QoYDZkVPuCf7-4&usqp=CAU" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
		        <p class="card-text">This is a short card.</p>
		      </div>
		    </div>
		  </div>
		  <div class="col mb-4">
		    <div class="card h-100">
		      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTK_RUTu0SznfdZVTjicAG3ingUuM38Dy6PyA&usqp=CAU" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
		        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
		      </div>
		    </div>
		  </div>
		  <div class="col mb-4">
		    <div class="card h-100">
		      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhWov14WDk3G3RVAWZzTDS6Fx5kSDMuNxfhA&usqp=CAU" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
		        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	<footer class="bg-dark text-white mt-4  text-center">Connect me at kamleshp097@gmail.com</footer>
</div>
</body>
</html>