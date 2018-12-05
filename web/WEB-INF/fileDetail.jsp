<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Details Table</title>
        <!--<link href="style.css" rel="stylesheet" type="text/css">-->
    </head>
    <body class="main" style="background-color:lightcyan">
        <%@include file="../header.jsp" %>
        <div class="container-fluid" >
            <div class="row">
                <div class="col-lg-12">
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/DhRYvT-pBkA?rel=0" allowfullscreen></iframe>
                    </div>
                    <table class="table table-striped table-bordered table-hover table-dark">
                        <thead>
                            <tr class="active">
                                <th>FILE ID</th>
                                <th>FILE Name</th>
                                <th>FILE TYPE</th>
                                <th>CREATE TIME</th>
                                <th>FILE SIZE</th>       
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${fileDetails}">
                                <tr>
                                    <td class="success">
                                        <p title="${item.file_id}">${item.file_id}</p>
                                    </td>
                                    <td class="warning">
                                        <p title="${item.name}">${item.name}</p>
                                    </td>
                                    <td class="info">
                                        <p title="${item.type}">${item.type}</p>
                                    </td>
                                    <td class="warning">
                                        <p title="${item.date}">${item.date}</p>
                                    </td>
                                    <td class="table-dark">
                                        <p title="${item.size}">${item.size}</p>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>    
            </div>
        </div>
    </body>
</html>