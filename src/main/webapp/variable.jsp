<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="variableBean" class="org.example.javalab.VariableBean" scope="session"/>

<%
  String newValue = request.getParameter("value");
  if (newValue != null && !newValue.isEmpty()) {
    variableBean.setValue(newValue);
  }
%>

<html>
<head>
  <title>Set and Get Variable</title>
</head>
<body>
<h2>Set a Value</h2>
<form action="variable.jsp" method="post">
  <label for="value">Enter value:</label>
  <input type="text" name="value" id="value" />
  <input type="submit" value="Submit" />
</form>

<h2>Current Value: <%= variableBean.getValue() %></h2>
</body>
</html>