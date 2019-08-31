<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="/">
<meta charset="ISO-8859-1">
<title>Stock Market Charting</title>
<head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>HomePage</title>
      <link rel="stylesheet" type="text/css" href="/css/HomePage.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
      <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" ></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" ></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">  
	<script type="text/javascript">
	$( function() {
        			$( "#hello" ).autocomplete({
        				source:${StringList},
        				minLength:1
        			});
        		});
	</script>

<script type="text/javascript">
window.onload = function canvasfunction() {
 
var dps = [[]];
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	animationEnabled: true,
	zoomEnabled: true,
	title: {
		text: "Company Data"
	},
	axisX: {
		  title: "timeline",
		  intervalType: "day"
	},
	axisY: {
		title: "Price (in billion INR)",
		suffix: " °C"
	},
	data: [{
		type: "line",
		xValueType: "dateTime",
		xValueFormatString: "MMM",
		yValueFormatString: "#,##0 °C",
		dataPoints: dps[0]
	}]
});
 
var xValue;
var yValue;
 
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
		xValue = parseInt("${dataPoint.x}");
		yValue = parseFloat("${dataPoint.y}");
		dps[parseInt("${loop.index}")].push({
			x : xValue,
			y : yValue
		});		
	</c:forEach>	
</c:forEach> 
 
chart.render();

}

</script>


</head>
<body >

	 <nav id="sidebar">
             <div id="dismiss">
            <i class="fas fa-arrow-left"></i>
        </div>

            <div class="sidebar-header">
                <h2>User</h2>
            </div>
            <ul class="list-unstyled components">
                <li class="active">
                    <a id="sidebarA" href="openUserLogin">SignUp/Login</a>
                </li>
                <li>
                    <a id="sidebarA" href="addAdminPage">Admin Login</a>
                </li>
				<li><button type="button" class="btn btn-dark">Logout</button> </li>
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
                                    <li><a href="saveUser">SignUp/Login</a></li>
                                    <li><a href="openPage">Admin Login</a></li>
									<li><button type="button" class="btn btn-dark">Logout</button> </li>
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
		<div id="chartContainer" style="height: 250px; width: 100%;"> </div>
		<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	
			</div>
			
			<div id ="tablee" class="col-sm-12 col-md-6">
			<h3>List all Stock</h3>
	<hr/>
	<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">Stock name</th>
      <th scope="col">Contact Address</th>
      <th scope="col">Brief</th>
	  <th scope="col">Remarks</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="k" items="${stockList}">
    <tr>
      <td>${k.stockName}</td>
      <td>${k.contactAddress}</td>
      <td>${k.brief}</td>
      <td>${k.remarks}</td>
    </tr>
     </c:forEach>
  </tbody>
</table>
			</div>
			</div>
			
			<div class="row">
			<form:form  action="getCompany"  method="GET" >
				<div style="text-align:right;" class="col-sm-6 col-md-6 col-xs-6 col-lg-6">
				<input type="text" id="hello" name="hello"/>
	
			</div>
			<div style="text-align:left;"  class="col-sm-6 col-md-6 col-xs-6 col-lg-6">
				<input type="submit" id="companysearch" value="Search"/>
	
			</div>
			</form:form>
			</div>
			
			<br>
			<br>
			<br>
			<br>
	<div class="row">
		<div style="text-align:right;" id ="left-import-cell" class="col-sm-12 col-md-12 col-xs-12 col-lg-12">
			<table style="border:2px solid black;" class="table table-hover table-dark">
  				<thead>
   					 <tr>
				      <th scope="col">Company Code</th>
				      <th scope="col">CompanyName</th>
				      <th scope="col">Turnover</th>
					  <th scope="col">ceo</th>
					  
					  <th scope="col">boardOfDirectors</th>
				      <th scope="col">sectorId</th>
				      <th scope="col">breifWriteUp</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr style="text-align:left;">
				      <td>${companylist.companyCode}</td>
				      <td>${companylist.companyName}</td>
				      <td>${companylist.turnover}</td>
				      <td>${companylist.ceo}</td>
				      <td>${companylist.boardOfDirectors}</td>
				      <td>${companylist.sectorId}</td>
				      <td>${companylist.breifWriteUp}</td>
				    </tr>
		  </tbody>
		</table>
		</div>
			
	</div>
		</div>
	  
	  
	  
</body>
</html>




