<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<html>
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
    <script type="text/javascript" src="<c:url value='/resources/jstree/jquery.cookie.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/jstree/jquery.hotkeys.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/jstree/jquery.jstree.js' />"></script>
    <link type="text/css" href="<c:url value='/resources/jquery/css/smoothness/jquery-ui-1.8.22.custom.css'/>" rel="stylesheet" />
    <link type="text/css" href="<c:url value='/resources/jquery/css/jquery.dataTables.css'/>" rel="stylesheet" />
    <link type="text/css" href="<c:url value='/resources/jquery/css/jquery.dataTables_themeroller.css'/>" rel="stylesheet" />
    <link type="text/css" href="<c:url value='/resources/template/css/template.css' />" rel="stylesheet" />
    <link type="text/css" href="<c:url value='/dbp/css/dbp.css' />" rel="stylesheet" />
    <link type="text/css" href="<c:url value='/resources/jstree/themes/default/style.css'/>" rel="stylesheet" />
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
<script type="text/javascript">
$(document).ready(function() {
	$("#demo1").jstree(
			{ 
				"plugins" : [ "themes", "html_data", "ui", "crrm", "contextmenu" ],
				"contextmenu":{
					"items":{
						"rename" : {
						    // The item label
						    "label"             : "Rename",
						    // The function to execute upon a click
						    "action"            : function (obj) { 
						    	alert('adios:' + obj.text());
						    	this.rename(obj); 
						    	},
						    // All below are optional
						    "_disabled"         : false,     // clicking the item won't do a thing
						    "_class"            : "class",  // class is applied to the item LI node
						    "separator_before"  : false,    // Insert a separator before the item
						    "separator_after"   : true,     // Insert a separator after the item
						    "icon"              : false,
						}
				}
				}
			}		
	);
});
/**
 * { 
		"plugins" : [ "themes", "html_data", "ui", "crrm", "contextmenu" ]
	}
 */
</script>
</head>
<body>
	<div class="panel">
		<h3>Using the contextmenu</h3>
		<div id="demo1" class="demo">
			<ul>
				<li id="phtml_1"><a href="#">Root node 1</a>
					<ul>
						<li id="phtml_2"><a href="#">Child node 1</a></li>
						<li id="phtml_3"><a href="#">Child node 2</a></li>
					</ul></li>
				<li id="phtml_4"><a href="#">Root node 2</a></li>
			</ul>
		</div>
</body>
</html>
