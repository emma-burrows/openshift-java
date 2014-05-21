<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="bean" class="com.eburrows.openshift.ArchiveBean" />

<t:layout>
  <jsp:attribute name="pageTitle">API Proof of Concept in Java</jsp:attribute>

  <jsp:body>
    <c:forEach var="work" items="${bean.works}">
      <c:set var="work" value="${work}" scope="request"/>
      <p><a href="<c:out value="/Work.jsp?id=${work.getId()}"/>"><c:out value="${work.getTitle()}" /></a></p>
      <jsp:include page="Blurb.jsp"/>
    </c:forEach>
  </jsp:body>

</t:layout>

