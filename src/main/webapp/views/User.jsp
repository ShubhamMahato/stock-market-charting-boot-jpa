
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>User</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
      <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" ></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" ></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">  
	<script type="text/javascript">
	$( function() {
        			$( "#hell" ).autocomplete({
        				source:${companyList},
        				minLength:1
        			});
        		});
	</script>
	<script type="text/javascript">
document.write(${dataPointsList}});
	</script>
<script type="text/javascript">
window.onload = function canvasfunction() {
 
var dps = ${str};
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	animationEnabled: true,
	zoomEnabled: true, 
	title: {
		text: "Company Data"
	},
	axisX: {
		  title: "timeline",
		  intervalType: "year"
	},
	axisY: {
		title: "Price (in billion INR)",
		suffix: " INR"
	},
	toolTip: {
		shared: true
	},
	legend: {
		cursor: "pointer",
	},
	data: [
{
		
		type: "line",
		xValueType: "dateTime",
		xValueFormatString: "MMM",
		yValueFormatString: "#,##0 INR",
		name: "Company 1",
		dataPoints: dps[0]
	},
{
		
		type: "line",
		xValueType: "dateTime",
		xValueFormatString: "MMM",
		yValueFormatString: "#,##0 INR",
		name: "Company 2",
		dataPoints: dps[1]
	},
{
		
		type: "line",
		xValueType: "dateTime",
		xValueFormatString: "MMM",
		yValueFormatString: "#,##0 INR",
		name: "Company 3",
		dataPoints: dps[2]
	},
{
		
		type: "line",
		xValueType: "dateTime",
		xValueFormatString: "MMM",
		yValueFormatString: "#,##0 INR",
		name: "Company 4",
		dataPoints: dps[3]
	},
{
		
		type: "line",
		xValueType: "dateTime",
		xValueFormatString: "MMM",
		yValueFormatString: "#,##0 INR",
		name: "Company 5",
		dataPoints: dps[4]
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



var chartType = document.getElementById('chartType');
chartType.addEventListener( "change",  function(){
  chart.options.data[0].type = chartType.options[chartType.selectedIndex].value;
  chart.options.data[1].type = chartType.options[chartType.selectedIndex].value;
  chart.options.data[2].type = chartType.options[chartType.selectedIndex].value;
  chart.options.data[3].type = chartType.options[chartType.selectedIndex].value;
  chart.options.data[4].type = chartType.options[chartType.selectedIndex].value;
  chart.render();
});


}

</script>
<script type="text/javascript">
document.write("${datatypeset}");
</script>
</head>
<body>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<br>
	<br>
	
	
	
	
<div>Chart Type:
  <select id="chartType" name="Chart Type">
    <option value="line">Line</option>
    <option value="column">Column</option>
    <option value="bar">Bar</option>
    <option value="pie">Pie</option>
    <option value="doughnut">Doughnut</option>
    <!-- <option value="spline">spline</option>
    <option value="splineArea">splineArea</option>
    <option value="stepLine">stepLine</option>
    <option value="scatter">scatter</option> -->
  </select>  
</div>




<hr>

 <div class="container" style="width:100%;padding:10px;">

  <div class="col-sm-4 col-lg-4 col-md-4" >

  <form action="getUserByDateAndCompany"  method="GET"  commandName="stockprice">
  
  <p style="color:red;">Add Company separated by for multiple companies</p>
    <div class="col-sm-2 col-lg-2 col-md-2" style="text-align:left;">
    	
	
    	<p  >Company Code</p>
    	<p   >From Date</p>
		<p  >To Date</p>
		
		
    </div>
     
    <div class="col-sm-2 col-lg-2 col-md-2">
     <input style="margin:10px;" type="text" id="hello" name="companyc"/><br>
      		<input style="margin:10px;" type="date"name="startd" /><br>
      		<input style="margin:10px;" type="date" name="endd"/><br>
      		<input style="margin:10px;" type="submit" value="Submit"/>
    </div>
   </form>

</div>

 <div class="col-sm-4 col-lg-4 col-md-4" >
<p style="color:red;">Add Sectors separated by for multiple Sectors</p>
  <form action="getUserBySectors"  method="GET"  commandName="stockprice">
    <div class="col-sm-2 col-lg-2 col-md-2">
    	
		<p >Sector Name</p>
    	<p  >From Date</p>
		<p >To Date</p>
		
		
    </div>
     
    <div class="col-sm-2 col-lg-2 col-md-2">
     <input  style="margin:10px;" type="text" id="hello" name="sectorc"/><br>
      		<input  style="margin:10px;"  type="date"name="sstartd" /><br>
      		<input style="margin:10px;" type="date" name="sendd"/><br>
      		<input  style="margin:10px;" type="submit" value="Submit"/>
    </div>
   </form>

</div>

 <div class="col-sm-4 col-lg-4 col-md-4" >
<p style="color:red;">Add Sectors separated by for multiple companies</p>
  <form action="getUserBySectorsAndCompany"  method="GET"  commandName="stockprice">
    <div class="col-sm-2 col-lg-2 col-md-2">
    	<p >Company Code</p>
		<p >Sector Name</p>
    	<p  >From Date</p>
		<p >To Date</p>
		
		
    </div>
     
    <div class="col-sm-2 col-lg-2 col-md-2">
    <input  style="margin:10px;" type="text" id="hello" name="companyc"/><br>
     <input  style="margin:10px;" type="text" id="hello" name="sectorc"/><br>
      		<input  style="margin:10px;"  type="date"name="sstartd" /><br>
      		<input style="margin:10px;" type="date" name="sendd"/><br>
      		<input  style="margin:10px;" type="submit" value="Submit"/>
    </div>
   </form>

</div>
</div>


<br>
<br>
<br>

<div>
	<h2 style="text-align:center;">Search Ipo</h2>
	<br>
	<br>
	<div class="row">
			<form:form  action="getIpo"  method="GET" >
				<div style="text-align:right;" class="col-sm-6 col-md-6 col-xs-6 col-lg-6">
				<input type="text" id="hell" name="hell"/>
	
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
			 <table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">Company Name</th>
      <th scope="col">Exchange</th>
      <th scope="col">Price per share</th>
        <th scope="col">Remarks</th>
    </tr>
  </thead>
  <tbody>
    <tr style="text-align:left;">
      	 <td>${ipo.companyName}</td>
      	 <td>${ipo.stockExchange}</td>
      	  <td>${ipo.pricePerShare}</td>
      	  <td>${ipo.remarks}</td>
    </tr>
  </tbody>
</table>
		</div>
</div>

</body>
</html> 