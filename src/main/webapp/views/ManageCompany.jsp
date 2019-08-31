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
	<link rel="stylesheet" type="text/css" href="/css/ManageCompanyStyle.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">  
	<script type="text/javascript">
	$( function() {
        			$( "#stockcode" ).autocomplete({
        				source:${StringList},
        				minLength:1
        			});
        		});
	</script>
	<script type="text/javascript">
	$( function() {
        			$( "#sector" ).autocomplete({
        				source:${StringList1},
        				minLength:1
        			});
        		});
	</script>
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
                   <a id="sidebarA" href="openSector">Sectors</a>
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
                                    <li>   <a href="openSector">Sectors</a></li>
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
		<h3>Create New Company</h3>
		<hr/>
	
	
	
	<form:form action="saveCompany"  method="POST"  modelAttribute="company">
	<div class="container-fluid"> 
            <div class="row" class="i-am-centered">
                <div style="text-align:right" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                <p id="pid">CompanyId:</p>
                 <p id="pid">CompanyCode:</p>
                   <p id="pid">CompanyName:</p>
					<p id="pid">Ceo :</p>
					<p id="pid">Board of member name:</p>
					<p id="pid">TurnOver:</p>
					<p id="pid">Brief:</p>
					<p id="pid">Sector:</p>
					<p id="pid">Stock Code:</p>
                </div>
            <div style="text-align:left" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
           		 <form:input path="companyId"  type="text" id="cid" name="cid" placeholder="id will be assigned" readonly="true" /><br><br>
           		 
				<form:input path="companyCode"  type="text" id="ccode" name="ccode" placeholder="Enter Code"/><br><br>
				
				<form:input path="companyName"  type="text" id="cname" name="cname" placeholder="CompanyName"/><br><br>
				 
				<form:input  path="ceo" type="text"  id="ceoname" name="ceoname" placeholder="CeoName"/>
				 <br><br>
				 
				<form:input  path="boardOfDirectors"  id="bodname"  type="text" name="bodname" placeholder="BodName"/>
				 <br><br>
				
				<form:input  path="turnover"  type="text" id="turnover" name="turnover" placeholder="Turnover"/>
				 <br><br>
				
				<form:input  path="breifWriteUp"  type="text"  id="brief" name="Brief" placeholder="Brief"/>
				 <br><br>
				 
				<form:input  path="sectorId"  type="text" name="sector" id="sector" placeholder="Sector"/>
				
				 <br><br>
				 
				<form:input  path="stockExchangeId"  type="text"  name="stockExchangeCompany" id="stockcode" placeholder="Stock Code"/>
			
				 <br><br>
				<br><br>
				<input type="submit" name="action" value="save or update" />
				
				<p style="color:red">${msg}</p>
				
                </div>
                
                
                 <div style="text-align:center" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                 <form:errors path="companyId" cssClass="error"></form:errors>
				 <br><br>
				<form:errors path="companyCode" cssClass="error"></form:errors>
				 <br><br>
				
				 <form:errors path="companyName" cssClass="error"></form:errors>
				 <br><br>
				 
				 <form:errors path="ceo" cssClass="error"></form:errors>
				 <br><br>
				 
				 <form:errors path="boardOfDirectors" cssClass="error"></form:errors>
				 <br><br>
				
				 <form:errors path="turnover" cssClass="error"></form:errors>
				 <br><br>
				
				 <form:errors path="breifWriteUp" cssClass="error"></form:errors>
				 <br><br>
				 
				 <form:errors path="sectorId" cssClass="error"></form:errors>
				 <br><br>
				 
				 <form:errors path="stockExchangeId" cssClass="error"></form:errors>
				 <br><br>
                </div>
            </div>
        </div>
		</form:form>
			</div>
			<div id ="left-import-cell" class="col-sm-12 col-md-6">
			<h3>List of Company</h3>
	<hr/>
	<table id="myTable" class="table table-hover table-dark">
  <thead>
    <tr>
     <th scope="col">CompanyId</th>
       <th scope="col">Company Code</th>
      <th scope="col">Company Name</th>
      <th scope="col">Turnover</th>
      <th scope="col">CEO</th>
      <th scope="col">Board of director</th>
      <th scope="col">Breif</th>
	  <th scope="col">Sector</th>
	  <th scope="col">Stock Code</th>
    </tr>
  </thead>
  <tbody>
  <j:forEach var="c" items="${list}">
    <tr>
    <td>${c.companyId}</td>
     	<td>${c.companyCode}</td>
      	 <td>${c.companyName}</td>
     	 <td>${c.turnover}</td>
     	 <td>${c.ceo}</td>
     	 <td>${c.boardOfDirectors}</td>
     	 <td>${c.breifWriteUp}</td>
     	 <td>${c.sectorId}</td>
     	 <td>${c.stockExchangeId}</td>
    </tr>
    </j:forEach>
	
  </tbody>
</table>
 <script>
    
                var table = document.getElementById('myTable');
                
                for(var i = 1; i < table.rows.length; i++)
                {
                    table.rows[i].onclick = function()
                    {
                    	document.getElementById("cid").value = this.cells[0].innerHTML;
                    	document.getElementById("ccode").value = this.cells[1].innerHTML;
                    	document.getElementById("cname").value = this.cells[2].innerHTML;
                    	document.getElementById("ceoname").value = this.cells[4].innerHTML;
                    	document.getElementById("bodname").value = this.cells[5].innerHTML;
                    	document.getElementById("turnover").value = this.cells[3].innerHTML;
                    	document.getElementById("brief").value = this.cells[6].innerHTML;
                    	document.getElementById("sector").value = this.cells[7].innerHTML;
                    	document.getElementById("stockcode").value = this.cells[8].innerHTML;
                    	
                    };
                }
    
</script>
			</div>
			</div>
		</div>
	  
	  
</body>
</html>