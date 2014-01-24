<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false"%>
<c:set var="title"><tiles:getAsString name="titleName"/></c:set>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">

    <title>${title}</title>

    <!-- Core CSS - Include with every page -->
    <link href="/sabamiso/css/bootstrap.min.css" rel="stylesheet">
    <link href="/sabamiso/font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Page-Level Plugin CSS - Dashboard -->
    <link href="/sabamiso/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <link href="/sabamiso/css/plugins/timeline/timeline.css" rel="stylesheet">

    <!-- SB Admin CSS - Include with every page -->
    <link href="/sabamiso/css/sb-admin.css" rel="stylesheet">

    <!-- Core Scripts - Include with every page -->
    <script src="/sabamiso/js/jquery-1.10.2.js"></script>
    <script src="/sabamiso/js/bootstrap.min.js"></script>
    <script src="/sabamiso/js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- SB Admin Scripts - Include with every page -->
    <script src="/sabamiso/js/sb-admin.js"></script>

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
