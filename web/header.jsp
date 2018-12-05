<%-- 
    Document   : header
    Created on : Dec 3, 2018, 10:05:25 PM
    Author     : Guanghua He
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
       <nav class="navbar navbar-inverse navbar-static-top" style="background-color:black">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">CST8288 Assignment3</a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="${pageContext.request.contextPath}/student" target="main" >Student<span class="sr-only">(current)</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/group" target="main">Group</a></li>
                            <li><a href="${pageContext.request.contextPath}/FileForm" target="main">File Form</a></li>
                            <li><a href="${pageContext.request.contextPath}/FileDetail" target="main">File Detail</a></li>
                        </ul>
                    </div>
                </div>

            </nav>
    </body>
</html>
