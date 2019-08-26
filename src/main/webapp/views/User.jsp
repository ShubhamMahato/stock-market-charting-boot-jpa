
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>HomePage</title>
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
 
var dps = [[]];
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	animationEnabled: true,
	title: {
		text: "Company Data"
	},
	axisX: {
		  title: "timeline",
		  intervalType: "year"
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



var chartType = document.getElementById('chartType');
chartType.addEventListener( "change",  function(){
  chart.options.data[0].type = chartType.options[chartType.selectedIndex].value;
  chart.render();
});

}

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
  </select>  
</div>

<hr>

 <div class="container" style="padding:10px;">

  <div class="row" >
  <form:form  action="getUserByDateAndCompany"  method="GET" >>
    <div class="col-sm">
    	
	
    	<h5>From Date</h5>
		<h5>To Date</h5>
		
		
    </div>
     
    <div class="col-sm">
    <!-- <input type="text" id="hello" name="companyc"/><br>-->
      		<input type="date" name=startd/><br>
      		<input type="date" name=endd/><br>
      		<input type="submit" value="Submit"/>
    </div>
   </form:form>
  </div>
</div>


</body>
</html> 