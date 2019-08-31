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
                    <a id="sidebarA" href="openStockExchange">Manage Exchange</a>
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
                                    <li><a href="openStockExchange">Manage Exchange</a></li>
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
		<h3>Register New Sector</h3>
	<hr/>
	
	
	<form:form action="saveSectors"  method="POST"  modelAttribute="sector">
	<div class="container-fluid"> 
            <div class="row" class="i-am-centered">
                <div style="text-align:right" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                <p id="pid">Sector Name:</p>
                 <p id="pid">Brief:</p>
                </div>
            <div style="text-align:left" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
           		 <form:input path="companySectorName"  type="text" id="cid" name="cid" placeholder="Sector Name"/><br><br>
           		 
				<form:input path="sectorsBrief"  type="text" id="ccode" name="ccode" placeholder="Brief"/><br><br>
			
				<br><br>
				<input type="submit" name="action" value="save or update" />
				
				<p style="color:red">${msg}</p>
				
                </div>
                
                
                 <div style="text-align:center" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                 <form:errors path="companySectorName" cssClass="error"></form:errors>
				 <br><br>
				<form:errors path="sectorsBrief" cssClass="error"></form:errors>
				 <br><br>
				
                </div>
            </div>
        </div>
		</form:form>
	
			</div>
			<div id ="left-import-cell" class="col-sm-12 col-md-6">
			<h3>List all Sectors</h3>
	<hr/>
	<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">sectorName</th>
      <th scope="col">Brief</th>
    </tr>
  </thead>
  <tbody>
  <j:forEach var="c" items="${list}">
    <tr>
      	 <td>${c.companySectorName}</td>
      	 <td>${c.sectorsBrief}</td>
    </tr>
    </j:forEach>
  </tbody>
</table>
			</div>
			</div>
		</div>
</body>
</html>