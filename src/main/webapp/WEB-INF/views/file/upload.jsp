<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="row">
  <div class="col-lg-12">
    <h3 class="page-header">ファイルアップロード</h3>
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
    <i class="fa fa-upload fa-fw"></i> アップロード
  </div>
  <div class="panel-body">
  <!--  
    <form:form action="upload?${_csrf.parameterName}=${_csrf.token}" method="post" class="form-horizontal" role="form" enctype="multipart/form-data">
      <div class="form-group">
        <label for="inputFile" class="col-sm-2 control-label">Upload File</label>
        <span class="btn btn-default btn-file">
          Select <input type="file" name="file" id="inputFile" />
        </span>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <input type="submit" class="btn btn-primary" value="Upload" />
        </div>
      </div>
    </form:form>
    -->

<!--
<div style="width:500px;padding:20px">
 
    <input id="fileupload" type="file" name="files[]" data-url="upload?${_csrf.parameterName}=${_csrf.token}" multiple>
 
    <div id="dropzone" class="fade well">Drop files here</div>

    <div id="progress" class="progress">
        <div class="progress-bar" style="width: 0%;"></div>
    </div>

    <table id="uploaded-files" class="table">
        <tr>
            <th>File Name</th>
            <th>File Size</th>
            <th>File Type</th>
            <th>Download</th>
        </tr>
    </table>
 
</div>
-->
<div>
                <span class="btn btn-success fileinput-button">
                    <i class="glyphicon glyphicon-plus"></i>
                    <span>Add files...</span>
    <input id="fileupload" type="file" name="files[]" data-url="upload?${_csrf.parameterName}=${_csrf.token}" multiple>
                </span>
</div>
<br>
    <div id="progress" class="progress">
        <div class="progress-bar" style="width: 0%;"></div>
    </div>

    <div id=upload_button></div>

    <table role="presentation" class="table table-striped">
        <thead>
          <tr>
            <th>File Name</th>
            <th>File Size</th>
            <th>File Type</th>
            <th>Download</th>
          </tr>
        </thead>
        <tbody id="uploaded-files"></tbody>
    </table>

  </div>
</div>

<script type="text/javascript">
$(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .progress-bar').css(
                'width',
                progress + '%'
            );
        },
        add: function (e, data) {
            $('#progress .progress-bar').css(
                    'width', '0%'
                );
            data.context = $('<button class="btn btn-primary start"><i class="glyphicon glyphicon-upload"></i><span>Start upload</span></button>')
                .appendTo("#upload_button")
                .click(function () {
                    //data.context = $('<p/>').text('Uploading...').replaceAll($(this));
                    data.context = $('<p/>').text('').replaceAll($(this));
                    data.submit();
                });
        },
        done: function (e, data) {
            //data.context.text('Upload finished.');
            $.each(data.result, function (index, file) {
                $("#uploaded-files").append(
                        $('<tr/>')
                        .append($('<td/>').text(file.name))
                        .append($('<td/>').text(file.size))
                        .append($('<td/>').text(file.contentType))
                        .append($('<td/>').html("<a href='get/"+file.id+"'>Click</a>"))
                        );//end $("#uploaded-files").append()
            }); 
        }

    });
});

</script>
<!--
<link href="/sabamiso/css/dropzone.css" type="text/css" rel="stylesheet" />
<script src="/sabamiso/js/myuploadfunction.js"></script>
-->