<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">ユーザー管理</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
    <c:if test="${!empty message}">
      <div class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        ${message}
      </div>
    </c:if>
<div class="panel panel-default">
  <div class="panel-heading">
    <i class="fa fa-user fa-fw"></i> 編集
  </div>
  <div class="panel-body">
    <form:form action="save" modelAttribute="form" class="form-horizontal" role="form">
      <form:hidden path="user.userId" />
      <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">UserName</label>
        <div class="col-sm-10">
          <form:input path="user.userName" class="form-control" id="inputEmail" placeholder="Email" /><form:errors path="user.userName" cssClass="text-danger" />
        </div>
      </div>
      <div class="form-group">
        <label for="inputPassword" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
          <form:password path="user.password" class="form-control" id="inputPassword" placeholder="Password" /><form:errors path="user.password" cssClass="text-danger" />
        </div>
      </div>
      <div class="form-group">
        <label for="inputName" class="col-sm-2 control-label">Nickname</label>
        <div class="col-sm-10">
          <form:input path="user.nickname" class="form-control" id="inputName" placeholder="Name" /><form:errors path="user.nickname" cssClass="text-danger" />
        </div>
      </div>
      <div class="form-group">
        <label for="inputCompanyId" class="col-sm-2 control-label">ComapnyId</label>
        <div class="col-sm-10">
          <form:input path="user.companyId" class="form-control" id="inputCompanyId" placeholder="CompanyId" /><form:errors path="user.companyId" cssClass="text-danger"/>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <input type="submit" class="btn btn-primary" value="Save Changes" /> <input type="reset" class="btn btn-success" name="newUser" value="New User" onclick="setAddForm();" disabled="disabled" /> <input type="submit" class="btn btn-danger" name="deleteUser" value="Delete User" onclick="setDeleteForm();" disabled="disabled" />
        </div>
      </div>
    </form:form>

  </div>
        <script type="text/javascript">
            $(document).ready(function() {
                $(".text-danger").parent().parent().addClass("has-error");
            });
        </script>
</div>
