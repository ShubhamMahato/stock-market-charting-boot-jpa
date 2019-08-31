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
	<link rel="stylesheet" type="text/css" href="/css/ManageExchangeStyle.css">
	<style>
.error{
color:red;
font-family:sans-serif;
}
</style>

</head>
<body>
<nav id="sidebar">
             <div id="dismiss">
            <i class="fas fa-arrow-left"></i>
        </div>

            <div class="sidebar-header">
                <h2>Admin Features</h2>
            </div>
            <ul class="list-unstyled components">
                <li class="active">
                    <a id="sidebarA" href="importdata">Import Data</a>
                </li>
                <li>
                    <a id="sidebarA" href="openManageCompany">Manage Company</a>
                </li>
                <li>
                    <p id="sidebarA"  href="openSector">Sectors</p>
                </li>
                <li>
                    <a id="sidebarA" href="openipo">IPO Details</a>
                </li>
				<li><a href="/"><button type="button" class="btn btn-dark">Logout</button></a> </li>
            </ul>
      </nav>
      <div class="wrapper">
            <header>
			

                  <nav id="header1">
                        <div class="menu-icon">
                              <i class="fa fa-bars fa-2x"></i>
                        </div>

                        <div class="logo">
                              Stock Exchange
                        </div>

                        <div class="menu">

                              <ul>
                                    <li><a href="importdata">Import Data</a></li>
                                    <li><a href="openManageCompany">Manage Company</a></li>
                                    <li><p>Manage Exchange</p></li>
                                    <li><a href="openipo">IPO Details</a></li>
									<li><a href="/"><button type="button" class="btn btn-dark">Logout</button></a> </li>
                              </ul>
                        </div>
                  </nav>

            </header>

           </div>



      <script type="text/javascript">
      $(document).ready(function() {

        $('#dismiss').on('click', function () {
            // hide sidebar
            $('#sidebar').removeClass('active');
        });

            $(".menu-icon").on("click", function() {
                  /*$("nav ul").toggleClass("showing");*/
            $('#sidebar').toggleClass('active');
            });
      });
      </script>
	  
	  
	  
	  
	  
	  
	  
	  <div id="container">
	  <div class="row">
		<div id ="left-import-cell" class="col-sm-12 col-md-6">
		<h3>Register New Stock</h3>
	<hr/>
	
	
	<form:form action="saveStock"  method="POST"  modelAttribute="stock">
	<div class="container-fluid"> <!-- If Needed Left and Right Padding in 'md' and 'lg' screen means use container class -->
            <div class="row" class="i-am-centered">
                <div style="text-align:right" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                   <p id="pid">Stock Name:</p>
					<p id="pid">Contract Address:</p>
					<p id="pid">Brief:</p>
					<p id="pid">Remarks:</p>
				   
				   
                </div>
            <div style="text-align:left" class=col-xs-4 col-sm-4 col-md-4 col-lg-4">
				
				<form:input value="BSE" path="stockName" type="text" name="sname" placeholder="StockName"/><br><br>
				<form:input value="Delhi" path="contactAddress"  type="text" name="conadd" placeholder="Stock Exchange Name"/><br><br>
				<form:input value="Heha" path="brief" type="text" name="sBrief" placeholder="Breif"/><br><br>
				<form:input value="Not Good but god" path="remarks"  type="text" name="sremarks" placeholder="Remarks"/><br><br>
				<br><br>
				<input type="submit" value="Submit"/>
                </div>
                
                 <div style="text-align:center" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
				
				 <form:errors path="stockName" cssClass="error"></form:errors>
				 <br><br>
				 
				 <form:errors path="contactAddress" cssClass="error"></form:errors>
				 <br><br>
				 
				 <form:errors path="brief" cssClass="error"></form:errors>
				 <br><br>
				
				 <form:errors path="remarks" cssClass="error"></form:errors>
				 <br><br>
                </div>
            </div>
        </div>
        <p style="color:red;">${msg}</p>
		</form:form>
	
			</div>
			<div id ="left-import-cell" class="col-sm-12 col-md-6">
			<h3>List all Stock</h3>
	<hr/>
	<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">Stock Name</th>
      <th scope="col">Contact Address</th>
      <th scope="col">Breif</th>
	  <th scope="col">Remarks</th>
    </tr>
  </thead>
  <tbody>
  <j:forEach var="c" items="${list}">
    <tr>
      	 <td>${c.stockName}</td>
     	 <td>${c.contactAddress}</td>
     	 <td>${c.brief}</td>
     	 <td>${c.remarks}</td>
    </tr>
    </j:forEach>
  </tbody>
</table>
			</div>
			</div>
		</div>
</body>
</html>