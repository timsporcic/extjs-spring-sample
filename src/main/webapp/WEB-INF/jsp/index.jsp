<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring-ExtJS</title>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1" />
    <meta name="description" content="ExJS-Spring Sample" />
    <meta name="keywords" content="extjs,spring framework" />
    <link href="http://extjs.cachefly.net/ext-3.3.0/resources/css/ext-all.css" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"  type="text/css" />
    <script type="text/javascript" src="http://extjs.cachefly.net/ext-3.3.0/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="http://extjs.cachefly.net/ext-3.3.0/ext-all.js"></script>
    <script type="text/javascript">
        Ext.BLANK_IMAGE_URL = "http://extjs.cachefly.net/ext-3.3.0/resources/images/default/s.gif";
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
</head>
<body>
    <h1><s:message code="welcome"/></h1>
</body>
</html>