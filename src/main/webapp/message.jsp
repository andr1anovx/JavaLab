<%@ page import="org.example.javalab.MessageBean" %>
<jsp:useBean id="messageBean" class="org.example.javalab.MessageBean" scope="session" />

<html>
<head>
  <title>Set and Get Message</title>
</head>
<body>
<h2>Set a Message:</h2>
<form action="setMessage.jsp" method="post">
  <input type="text" name="newMessage" placeholder="Enter your message:" />
  <input type="submit" value="Set Message" />
</form>

<h2>Current Message:</h2>
<p>${messageBean.message}</p>
</body>
</html>

