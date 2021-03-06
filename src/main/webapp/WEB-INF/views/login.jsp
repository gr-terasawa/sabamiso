<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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

</head>

<body>

  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
          <div class="panel-heading">
            <span class="glyphicon glyphicon-lock"></span><span class="panel-title"> Please Sign In</span>
          </div>
          <div class="panel-body">
            <form role="form" action="<c:url value='j_spring_security_check' />" method="POST">
              <fieldset>
                <div class="form-group">
                  <input class="form-control" placeholder="E-mail" name="j_username" type="email" required autofocus>
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Password" name="j_password" type="password" required>
                </div>
                <div class="checkbox">
                  <label for="_spring_security_remember_me"> <input id="_spring_security_remember_me" type="checkbox" name='_spring_security_remember_me' /> Remember me
                  </label>
                </div>
                <!-- Change this to a button or input when using this as a form -->
                <button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
              </fieldset>
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
          </div>
          <div class="panel-footer">
            <c:if test="${not empty param.error}">
              <span class="text-danger">
                <spring:message code="login.error" />
              </span>
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
