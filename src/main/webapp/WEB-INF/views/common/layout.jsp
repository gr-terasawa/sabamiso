<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<c:set var="title"><tiles:getAsString name="titleName"/></c:set>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">

    <title>${title}</title>

    <!-- Core CSS - Include with every page -->
    <link href="<spring:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<spring:url value="/font-awesome/css/font-awesome.css" />" rel="stylesheet">

    <!-- Page-Level Plugin CSS - Dashboard -->
    <link href="<spring:url value="/css/plugins/morris/morris-0.4.3.min.css" />" rel="stylesheet">
    <link href="<spring:url value="/css/plugins/timeline/timeline.css" />" rel="stylesheet">

    <!-- SB Admin CSS - Include with every page -->
    <link href="<spring:url value="/css/sb-admin.css" />" rel="stylesheet">

    <link href="<spring:url value="/css/jquery.fileupload.css" />" rel="stylesheet">
    <link href="<spring:url value="/css/jquery.fileupload-ui.css" />" rel="stylesheet">

    <!-- Core Scripts - Include with every page -->
    <script src="<spring:url value="/js/jquery-1.10.2.js" />"></script>

    <script src="<spring:url value="/js/jquery.ui.widget.js" />"></script>
    <script src="<spring:url value="/js/jquery.iframe-transport.js" />"></script>
    <script src="<spring:url value="/js/jquery.fileupload.js" />"></script>

    <script src="<spring:url value="/js/bootstrap.min.js" />"></script>
    <script src="<spring:url value="/js/plugins/metisMenu/jquery.metisMenu.js" />"></script>

    <!-- SB Admin Scripts - Include with every page -->
    <script src="<spring:url value="/js/sb-admin.js" />"></script>

</head>

<body>

    <div id="wrapper">

        <tiles:insertAttribute name="header"/>

        <tiles:insertAttribute name="side"/>

        <div id="page-wrapper">
            <tiles:insertAttribute name="body"/>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

</body>

</html>
