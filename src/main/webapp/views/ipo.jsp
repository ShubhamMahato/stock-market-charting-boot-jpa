<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ipo</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>



	<link rel="stylesheet" type="text/css" href="/css/ManageExchangeStyle.css">
	 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">  
	<script type="text/javascript">
	$( function() {
        			$( "#cid" ).autocomplete({
        				source:${StringList},
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
                    <a id="sidebarA" href="openManageCompany">Manage Company</a>
                </li>
                <li>
                    <a id="sidebarA" href="openStockExchange">Manage Exchange</a>
                </li>
                <li>
                    <p>IPO Details</p>
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
                                    <li><p>IPO Details</p></li>
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
		<h3>Register New Ipo</h3>
	<hr/>
	
	
	<form:form action="saveIpo"  method="POST"  modelAttribute="ipo">
	<div class="container-fluid"> 
            <div class="row" class="i-am-centered">
                <div style="text-align:right" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                 <p id="pid">Id</p>
                <p id="pid">Company Name:</p>
                 <p id="pid">Stock Exchnage</p>
                 <p id="pid">Price per share</p>
                 <p id="pid">Total Share</p>
                 <p id="pid">Remarks</p>
                </div>
            <div style="text-align:left" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
            <form:input path="id"  type="text" id="id" name="id" placeholder="id will be generated " readonly="true"/><br><br>
            
           		<form:input path="companyName"  type="text" id="cid" name="cid" placeholder="company Name"/><br><br>
           		 
				<form:input path="stockExchange"  type="text" id="ccode" name="ccode" placeholder="exchange" readonly="true"/><br><br>
				
				<form:input path="pricePerShare"  type="text" id="pcode" name="pcode" placeholder="Price per share"/><br><br>
				
				<form:input path="TotalShare"  type="text" id="tcode" name="tcode" placeholder="Total share"/><br><br>
				
				<form:input path="remarks"  type="text" id="rcode" name="rcode" placeholder="Remarks"/><br><br>
				
				<br><br>
				<input type="submit" name="action" value="save or update" />
				
				<p style="color:red">${msg}</p>
				
                </div>
                
                
                 <div style="text-align:center" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                  <form:errors path="id" cssClass="error"></form:errors>
                   <br><br>
                 <form:errors path="companyName" cssClass="error"></form:errors>
				 <br><br>
				<form:errors path="stockExchange" cssClass="error"></form:errors>
				 <br><br>
				 <form:errors path="pricePerShare" cssClass="error"></form:errors>
				 <br><br>
				<form:errors path="TotalShare" cssClass="error"></form:errors>
				 <br><br>
				<form:errors path="remarks" cssClass="error"></form:errors>
				 <br><br>
                </div>
            </div>
        </div>
		</form:form>
	
			</div>
			<div id ="left-import-cell" class="col-sm-12 col-md-6">
			<h3>List all Ipo</h3>
	<hr/>
	 <table id="myTable" class="table table-hover table-dark">
  <thead>
    <tr>
    <th scope="col">Id</th>
      <th scope="col">Company Name</th>
      <th scope="col">Exchange</th>
      <th scope="col">Price per share</th>
      <th scope="col">Total share</th>
        <th scope="col">Remarks</th>
    </tr>
  </thead>
  <tbody>
  <j:forEach var="c" items="${list}">
    <tr>
    <td>${c.id}</td>
      	 <td>${c.companyName}</td>
      	 <td>${c.stockExchange}</td>
      	  <td>${c.pricePerShare}</td>
      	   <td>${c.totalShare}</td>
      	  <td>${c.remarks}</td>
      	  
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
                    	document.getElementById("id").value = this.cells[0].innerHTML;
                    	document.getElementById("cid").value = this.cells[1].innerHTML;
                    	document.getElementById("ccode").value = this.cells[2].innerHTML;
                    	document.getElementById("pcode").value = this.cells[3].innerHTML;
                    	document.getElementById("tcode").value = this.cells[4].innerHTML;
                    	document.getElementById("rcode").value = this.cells[5].innerHTML;
                    	
                    };
                }
    
</script>
			</div>
			</div>
		</div>
</body>
</html>