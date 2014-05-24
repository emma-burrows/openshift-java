<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="bean" class="com.eburrows.openshift.ArchiveBean" scope="session" />

<t:layout>
  <jsp:attribute name="pageTitle">API Proof of Concept - Java</jsp:attribute>

  <jsp:body>
    <c:forEach var="work" items="${bean.works}">
      <div style="border-bottom: 1px #e2e2e2 solid">
        <c:set var="work" value="${work}" scope="request"/>
        <h4><a href="<c:out value="/Work.jsp?id=${work.getId()}"/>"><c:out value="${work.getTitle()}" /></a>
          <small>by <c:forEach var="creator" items="${work.creators}" varStatus="loop">${creator.name}<c:if test="${!loop.last}">, </c:if></c:forEach> </small>
        </h4>
        <jsp:include page="Blurb.jsp"/>
      </div>
    </c:forEach>
  </jsp:body>

</t:layout>

