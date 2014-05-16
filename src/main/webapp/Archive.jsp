<%@ page import="org.otw.archive.ArchiveClient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Archive list</title>
</head>
<body>
  <%
    ArchiveClient archiveClient = new ArchiveClient("");
    archiveClient.connectToArchive();
  %>
  <p><%= archiveClient.work %></p>
</body>
</html>
