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
	<link rel="stylesheet" type="text/css" href="/css/ImportData.css">
	 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> 
	<style>
.error{
color:red;
font-family:sans-serif;
}
</style>
</head>
<body>

<div>
      <nav id="sidebar">
             <div id="dismiss">
            <i class="fas fa-arrow-left"></i>
        </div>

            <div class="sidebar-header">
                <h2>Admin Features</h2>
            </div>
            <ul class="list-unstyled components">
                <li class="active">
                    <p>Import Data</p>
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
                                    <li><p>Import Data</p></li>
                                    <li><a href="openManageCompany">Manage Company</a></li>
                                    <li><a href="openStockExchange">Manage Exchange</a></li>
                                    <li><a href="openipo">IPO Details</a></li>
									<li><a href="/"><button type="button" class="btn btn-dark">Logout</button></a> </li>
                              </ul>
                        </div>
                  </nav>

            </header>

           



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
		<h2>Import Excel</h2>
			<hr/>
			<h3>Select Excel file to be Uploaded</h3>
			<br>
				<br>
			
				<form:form action="ab" method="post" enctype="multipart/form-data">
					<input type="file" name="file" size=5000>
					<input type="submit" name="submit">
				</form:form>
				<br>
			<br>
			<button onclick="document.getElementById('imageReplace').src='/images/Sample.png'">Click here to Preview sample excel file</button>
			</div>
			<div id ="left-import-cell" class="col-sm-12 col-md-6">
			<img src="/images/excel.png"  id="imageReplace" alt="Excel File.Png">
			</div>
			</div>
		</div>
			
			
			
			</div>
</div>
</body>
</html>