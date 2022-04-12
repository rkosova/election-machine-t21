<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Admin Page</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    
</head>
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("Admin")== null) )
{
%>
<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
<%} %>
<body>  
    <nav id="siteNav" class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav navbar-right">
                Welcome <%=request.getAttribute("userName") %>
                    <li class="active">
                        <a href='/hello'>Welcome</a>
                    </li>
                    <li>
                        <a href='../adduser.jsp'>Add User</a>
                    </li>
                    <li>
                        <a href="/ShowUser">Show Users</a>
                    </li>
                    <li>
                        <a href='/AddQuestion'>Add question</a>
                    </li>
                    <li>
                        <a href="/ShowQuestion">Show questions</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
                    </li>
                    
                </ul>
                
            </div>
        </div>
    </nav>

	<!-- Header -->
    <header>
        <div class="header-content">
            <h1>Vote</h1>
            <div class="header-content-inner">
                <p>Choose the best candidate based on their answers</p>
                <a href="#" class="btn btn-primary btn-lg">Vote</a>
            </div>
        </div>
    </header>
    <section class="intro">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <h2 class="section-heading">Register with us</h2>
                    <p class="text-light">To vote you need to be at least 18 years of age and be registered with us!</p>
                </div>
            </div>
        </div>
    </section>

</body>
</html>