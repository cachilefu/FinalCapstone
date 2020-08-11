<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Show Manager</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <!-- css -->
  <link href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700" rel="stylesheet">
  <link href="static/css/bootstrap.css" rel="stylesheet" />
  <link href="static/css/bootstrap-responsive.css" rel="stylesheet" />
  <link href="static/css/fancybox/jquery.fancybox.css" rel="stylesheet">
  <link href="static/css/jcarousel.css" rel="stylesheet" />
  <link href="static/css/flexslider.css" rel="stylesheet" />
  <link href="static/css/style.css" rel="stylesheet" />
  <!-- Theme skin -->
  <link href="static/skins/default.css" rel="stylesheet" />
  <!-- boxed bg -->
  <link id="bodybg" href="bodybg/bg1.css" rel="stylesheet" type="text/css" />
  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png" />
  <link rel="shortcut icon" href="ico/favicon.png" />

  <!-- =======================================================
    Theme Name: Flattern
    Theme URL: https://bootstrapmade.com/flattern-multipurpose-bootstrap-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body>
  <div id="wrapper">
    <!-- toggle top area -->
    <div class="hidden-top">
      <div class="hidden-top-inner container">
        <div class="row">
          <div class="span12">
            <ul>
              <li><strong>We are available for any custom works this month</strong></li>
              <li>Main office: Springville center X264, Park Ave S.01</li>
              <li>Call us <i class="icon-phone"></i> (123) 456-7890 - (123) 555-7891</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <!-- end toggle top area -->
    <!-- start header -->
    <jsp:include page="header.jsp"/>
    <!-- end header -->
    <section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="inner-heading">
              <h2>New Show</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="#"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li><a href="#">Pages</a><i class="icon-angle-right"></i></li>
              <li class="active">New Show</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
   <!--  <section id="content"> -->
    <div align="center">
    <h2></h2>
   <form:form action="save" method="post" modelAttribute="show">
			<table border="0" cellpadding="5">
				<tr>
					<td>Name: </td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Demographic: </td>
					<td><form:input path="demo" /></td>
				</tr>
				<tr>
					<td>Genre: </td>
					<td><form:input path="genre" /></td>
				</tr>		
				<tr>
					<td>Studio: </td>
					<td><form:input path="studio" /></td>
				</tr>		
				<tr>
					<td>Year: </td>
					<td><form:input path="year" /></td>
				</tr>		
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>						
			</table>
		</form:form>
</div> 


<%--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Show</title>
</head>
<body>
	<div align="center">
		<h2>New Show</h2>
		<form:form action="save" method="post" modelAttribute="show">
			<table border="0" cellpadding="5">
				<tr>
					<td>Name: </td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Demographic: </td>
					<td><form:input path="demo" /></td>
				</tr>
				<tr>
					<td>Genre: </td>
					<td><form:input path="genre" /></td>
				</tr>		
				<tr>
					<td>Studio: </td>
					<td><form:input path="studio" /></td>
				</tr>		
				<tr>
					<td>Year: </td>
					<td><form:input path="year" /></td>
				</tr>		
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>						
			</table>
		</form:form>
	</div>
</body>
</html> --%>