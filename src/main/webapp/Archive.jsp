<%@ page import="org.otw.archive.ArchiveClient" %>
<%@ page import="org.otw.archive.Work" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Archive list</title>
</head>
<body>
  <%
    ArchiveClient archiveClient = new ArchiveClient("");
    archiveClient.connectToArchive();

    for (Work work : archiveClient.getResponse()) {
  %>
  <p><%= work.getTitle() %></p>
  <% } %>
</body>
</html>
