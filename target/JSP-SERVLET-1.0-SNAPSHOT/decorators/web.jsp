<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><dec:title default="Trang chủ"/></title>

    <!-- css -->
    <link href="<c:url value='/Template/web/bootstrap/css/bootstrap.css' />" rel="stylesheet" type="text/css"
          media="all"/>
    <link href="<c:url value='/Template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>

</head>
<body>
<!-- header -->
<%@ include file="/common/Web/header.jsp" %>
<!-- header -->

<div class="container">
    <dec:body/>
</div>

<!-- footer -->
<%@ include file="/common/Web/footer.jsp" %>
<!-- footer -->

<script type="text/javascript" src="<c:url value='/Template/web/jquery/jquery.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/Template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>

</body>
</html>