<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Company</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/NewUserStyle.css">
	 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> 
	<style>
.error{
color:red;
font-family:sans-serif;
}
</style>

<script type="text/javascript">
	$( function() {
        			$( "#search" ).autocomplete({
        				source:${companyList},
        				minLength:1
        			});
        		});
	</script>
</head>
<body>
	
		<body>
		<div class="header">
			<a href="#default" class="logo">StockExchange</a>
			
			<div class="header-right">
			<p>${userName}</p>
			 <ul class="list-unstyled components">
				<li style="align:right"><a href=""><button type="button" class="btn btn-primary">Logout</button></a></li>
			</ul>
			 <ul class="list-unstyled components">
				<li style="align:center"><a href="updateuser"><button type="button" class="btn btn-primary">Update Profile</button></a></li>
			</ul>
			</div>
		</div>
		
		<br>
		<br>
		
		<main>
		<input id="tab1" type="radio" name="tabs" checked>
		<label for="tab1">IPO's</label>

		<input id="tab2" type="radio" name="tabs">
		<label for="tab2">Compare Company</label>
		
		
		<section id="content1">
		
		 <div class="tab-pane" id="profile" role="tabpanel" aria-labelledby="profile-tab">
	<h3>List of Company</h3>
	<hr/>
	<table class="table table-hover table-dark">
  <thead>
    <tr>
      
       <th scope="col">Company Name</th>
      <th scope="col">CEO</th>
      <th scope="col">Breif</th>
	  <th scope="col">Turnover</th>
	  <th scope="col">Stock Exchange</th>
	  <th scope="col">Stock Code</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Cognizant</td>
      <td>Brian Humphries</td>
      <td>Service Based</td>
      <td>4.1 Billion</td>
	  <td>BSE</td>
	  <td>1001</td>
    </tr>
	<tr>
      <td>Google</td>
      <td>Sunder Pichai</td>
      <td>Product &Service Based</td>
      <td>7 Billion</td>
	  <td>BSE</td>
	  <td>1002</td>
    </tr>
  </tbody>
</table>
  </div>
		</section>
		
		<section id="content2">
		<button type="button" title="Click to add more company details" style="float:right;" id="btnAddForm" onclick="CloneForm('myForm');"><i  style="font-size:24px" class="fa fa-plus" aria-hidden="true"></i></button>
		
		 <div class="row">
		<div id ="left-import-cell" class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
		
		 <input type="text" placeholder="Search"name="search" id="search"/>
			</div>
			<div id ="right-import-cell" class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			 <input class="btn btn-primary" type="submit" value="Search" id="but"/>
			</div>
		<!-- <div id ="left-import-cell" class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
		<p id="pidChart"> Select period of chart</p>
		</div>
		<div id ="right-import-cell" class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
			<select id="yearSelect">
			<option value="week">Week</option>
			<option value="month">Month</option>
			<option value="Quarter">Quarter</option>
			<option value="Year">Year</option>
			</select>
		</div>
		
		</div>
		<br><br><br><br>
		<form  name="myForm">
			<div class="container-fluid"> 
				<div class="row" class="i-am-centered">
					<div style="text-align:right" class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
						<p id="pid">Select Company Sectors:</p>
						<p id="pid">Select Stock Exchange:</p>
						<p id="pid">Company Name:</p>
						<p id="pid">From Period:</p>
						<input type="date" name="fromdate"><br><br>
				   
					</div>
					<div style="text-align:left" class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
				
						<input type="text" name="csector" placeholder="Select Company Sectors"/><br><br>
						<input type="text" name="cstock" placeholder="Select Stock Exchange"/><br><br>
						<input type="text" name="cname" placeholder="Company Name:"/><br><br>
						
						<p id="pid">To Period:</p>
						<input type="date" name="todate"><br>
						<br><br><br><br>
						<input type="submit" value="Generate map"/>
						
						<hr/>
					</div>
				</div>
			</div>
		</form>
		
		<script>
						function CloneForm(formName) {
						var formCount = document.forms.length;
						var oForm = document.forms[formName];
						var clone = oForm.cloneNode(true);
						clone.name += "_" + formCount;
						document.getElementById('content2').appendChild(clone);
						}
		</script>-->
		</section>
		
		
		</main>
		
		
		
		
		
		
		
		
		
		
		
		
		
	<!--	<div id="container">
	  <div class="row">
		<div id ="left-import-cell" class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
		 <input type="text" placeholder="Search"name="search" id="search"/>
			</div>
			<div id ="right-import-cell" class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
			 <input class="btn btn-primary" type="submit" value="Search" id="but"/>
			</div>
			</div>
			<hr/>
			<br>
			<br>
		<div class="row">
		<div id ="left-import-cell" class="col-sm-4 col-md-4">
		<p id="pidChart"> Select period of chart</p>
		</div>
		<div id ="right-import-cell" class="col-sm-4 col-md-4">
			<select id="yearSelect">
			<option value="week">week</option>
			<option value="month">month</option>
			<option value="Quarter">Quarter</option>
			<option value="Year">Year</option>
			</select>
		</div>
		</div>
		</div>-->
		
		
		
		
		
		
		
		
</body>
</html>