<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">

<title>Login</title>

<!-- Core CSS - Include with every page -->
<link href="<spring:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<spring:url value="/font-awesome/css/font-awesome.css" />" rel="stylesheet">

<!-- SB Admin CSS - Include with every page -->
<link href="<spring:url value="/css/sb-admin.css" />" rel="stylesheet">

<style type="text/css">
//body {
//  background: url(<spring:url value="/images/4.jpg" />) no-repeat center center fixed;
//  -webkit-background-size: cover;
//  -moz-background-size: cover;
//  -o-background-size: cover;
//  background-size: cover;
//}

//.panel-default {
//  opacity: 0.9;
//}
</style>

</head>

<body>

  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-7">
        <div class="panel panel-default">
          <div class="panel-heading">
            <span class="glyphicon glyphicon-lock"></span> Login
          </div>
          <div class="panel-body">
            <form class="form-horizontal" role="form" action="<c:url value='j_spring_security_check' />" method="POST">
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label"> Email</label>
                <div class="col-sm-9">
                  <input type="email" class="form-control" id="inputEmail3" placeholder="Email" name="j_username" required>
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-3 control-label"> Password</label>
                <div class="col-sm-9">
                  <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="j_password" required>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9">
                  <div class="checkbox">
                    <label for="_spring_security_remember_me">
                      <input id="_spring_security_remember_me" type="checkbox" name='_spring_security_remember_me'/> Remember me
                    </label>
                  </div>
                </div>
              </div>
              <div class="form-group last">
                <div class="col-sm-offset-3 col-sm-9">
                  <button type="submit" class="btn btn-success btn-sm">Sign in</button>
                  <button type="reset" class="btn btn-default btn-sm">Reset</button>
                </div>
              </div>
            </form>
          </div>
          <div class="panel-footer">
            &nbsp;
            <c:if test="${not empty param.error}">
              <div class="alert alert-danger">
                <spring:message code="login.error" />
              </div>
            </c:if>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Core Scripts - Include with every page -->
  <script src="<spring:url value="/js/jquery-1.10.2.js" />"></script>
  <script src="<spring:url value="/js/bootstrap.min.js" />"></script>
  <script src="<spring:url value="/js/plugins/metisMenu/jquery.metisMenu.js" />"></script>

</body>

</html>
