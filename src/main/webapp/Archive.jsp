<%@ page import="org.otw.archive.ArchiveClient" %>
<%@ page import="org.otw.archive.Work" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="bean" class="com.eburrows.openshift.ArchiveBean" />

<t:layout>
  <jsp:attribute name="pageTitle">AO3 API PoC</jsp:attribute>


  <jsp:body>
    <c:forEach var="work" items="${bean.works}">
      <p><a href="<c:out value="${work.getId()}"/>"><c:out value="${work.getTitle()}" /></a></p>
    </c:forEach>
  </jsp:body>

</t:layout>

