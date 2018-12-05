<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students table</title>
<!--<link href="style.css" rel="stylesheet" type="text/css">-->
</head>
<body class="main" style="background-color:lightcyan">
    <%@include file="../header.jsp" %>
    <div class="container-fluid" >
        <div class="row">
            <div class="col-lg-12">
<!--                <div class="embed-responsive embed-responsive-16by9">
  <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/DhRYvT-pBkA?rel=0" allowfullscreen></iframe>
</div>-->
                <form class="form-horizontal"  action="FileForm" method="post" enctype="multipart/form-data">
                      <div class="form-group">
                        <label for="file" class="col-sm-2 control-label">Name:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="file" name="" placeholder="">
                        </div>
                      </div>
                    <div class="form-group">
                        <label for="Blob" class="col-sm-2 control-label">Type:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="Blob" name="Blob" placeholder="">
                        </div>
                      </div>
                    <div class="form-group">
                        <label for="" class="col-sm-2 control-label">File:</label>
                        <div class="col-sm-8">
                            <input type="file" class="form-control" id="" name="file" placeholder="">
                        </div>
                      </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-8">
                          <button type="submit" class="btn btn-primary">Upload</button>
                        </div>
                      </div>
                </form>
            </div>    
        </div>
    </div>
</body>
</html>