<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">ユーザー管理</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- 
<div class="panel panel-default">
  <div class="panel-heading">
    <i class="fa fa-user fa-fw"></i> 編集
  </div>
  <div class="panel-body">
    <form:form action="add" name="userForm" commandName="user" class="form-horizontal" role="form">
      <form:hidden path="userId" />
      <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">UserName</label>
        <div class="col-sm-10">
          <form:input path="userName" class="form-control" id="inputEmail" placeholder="Email" /><form:errors path="userName" cssClass="text-danger"/>
        </div>
      </div>
      <div class="form-group">
        <label for="inputPassword" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
          <form:password path="password" class="form-control" id="inputPassword" placeholder="Password" /><form:errors path="password" cssClass="text-danger"/>
        </div>
      </div>
      <div class="form-group">
        <label for="inputName" class="col-sm-2 control-label">Nickname</label>
        <div class="col-sm-10">
          <form:input path="nickname" class="form-control" id="inputName" placeholder="Name" /><form:errors path="nickname" cssClass="text-danger" />
        </div>
      </div>
      <div class="form-group">
        <label for="inputCompanyId" class="col-sm-2 control-label">ComapnyId</label>
        <div class="col-sm-10">
          <form:input path="companyId" class="form-control" id="inputCompanyId" placeholder="CompanyId" /><form:errors path="companyId" cssClass="text-danger"/>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <input type="submit" class="btn btn-primary" value="Save Changes" /> <input type="reset" class="btn btn-success" name="newUser" value="New User" onclick="setAddForm();" disabled="disabled" /> <input type="submit" class="btn btn-danger" name="deleteUser" value="Delete User" onclick="setDeleteForm();" disabled="disabled" />
        </div>
      </div>
    </form:form>

  </div>

</div>
 -->
<c:if test="${!empty users}">
  <div class="panel panel-default">
    <div class="panel-heading">
      <i class="fa fa-table fa-fw"></i> 一覧
    </div>
    <!-- /.panel-heading -->
    <div class="panel-body">
      <div class="table-responsive">
        <table class="table table-striped table-bordered table-hover">
          <thead>
            <tr>
              <th>userId</th>
              <th>userName</th>
              <th>password</th>
              <th>nickname</th>
              <th>companyId</th>
              <th>entryDate</th>
              <th>updateDate</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="user" items="${users}">
              <tr id="${user.userId}" onclick="setUpdateForm('${user.userId}');">
                <td><c:out value="${user.userId}" /></td>
                <td><c:out value="${user.userName}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td><c:out value="${user.nickname}" /></td>
                <td><c:out value="${user.companyId}" /></td>
                <td><fmt:formatDate value="${user.entryDate}" pattern="yyyy/MM/dd"/></td>
                <td><fmt:formatDate value="${user.updateDate}" pattern="yyyy/MM/dd"/></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <!-- /.table-responsive -->
    </div>
    <!-- /.panel-body -->
  </div>
</c:if>
<!--
<script type="text/javascript" src='<c:url value="/resources/common.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/registration.js"/>'></script>
<script type="text/javascript">
	var projectUrl = '<c:url value="/"/>';
	if (projectUrl.indexOf(";", 0) != -1) {
		projectUrl = projectUrl.substring(0, projectUrl.indexOf(";", 0));
	}
</script>
  -->