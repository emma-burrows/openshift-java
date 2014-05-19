<%@ page import="org.otw.archive.ArchiveClient" %>
<%@ page import="org.otw.archive.Work" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Archive list</title>
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
  <%
    ArchiveClient archiveClient = new ArchiveClient("");
    archiveClient.connectToArchive();

    out.println(System.getenv("ARCHIVE_HOST"));

    for (Work work : archiveClient.getWorks()) {
  %>
  <p><a href="<%= work.getId()%>"><%= work.getTitle() %></a></p>
  <% } %>

  <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>
