<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<%@ taglib prefix="tiles" 	uri="http://tiles.apache.org/tags-tiles"%>
<fmt:requestEncoding value="UTF-8" />
<html class="translated-ltr">
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->  
    <script src="<c:url value='/resources/jquery/js/jquery-1.7.2.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='/resources/jquery/js/jquery-ui-1.8.22.custom.min.js'/>" ></script>
    <script src="<c:url value='/resources/template/js/util.js' />"></script>
    <script src="<c:url value='/resources/jquery/js/jquery.dataTables.min.js' />"></script>
    <link type="text/css" href="<c:url value='/resources/jquery/css/smoothness/jquery-ui-1.8.22.custom.css'/>" rel="stylesheet" />
    <link type="text/css" href="<c:url value='/resources/jquery/css/jquery.dataTables.css'/>" rel="stylesheet" />
    <link type="text/css" href="<c:url value='/resources/jquery/css/jquery.dataTables_themeroller.css'/>" rel="stylesheet" />
    <link type="text/css" href="<c:url value='/resources/template/css/template.css' />" rel="stylesheet" />
    <link type="text/css" href="<c:url value='/dbp/css/dbp.css' />" rel="stylesheet" />
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<tiles:insertAttribute name="headjs" />        
	
</head>
<body data-twttr-rendered="true">
	<tiles:insertAttribute name="header" />
	<div id="main" class="clearfix">
		<tiles:insertAttribute name="menu" />
		<div id="content">
	  		<tiles:insertAttribute name="body" />
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</fmt:bundle>
</html>