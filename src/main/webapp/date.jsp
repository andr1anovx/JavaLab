<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="dateBean" class="org.example.javalab.DateBean" scope="page"/>
<html>
<head>
    <title>Current Date</title>
</head>
<body>
<h2>Current Date: ${dateBean.currentDate}</h2>
</body>
</html>