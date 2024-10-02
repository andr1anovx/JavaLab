<%@ page import="org.example.javalab.MessageBean" %>
<jsp:useBean id="messageBean" class="org.example.javalab.MessageBean" scope="session" />

<%
    String newMessage = request.getParameter("newMessage");
    if (newMessage != null && !newMessage.isEmpty()) {
        messageBean.setMessage(newMessage);
    }
    response.sendRedirect("message.jsp");
%>

