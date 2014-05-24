<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div><b>Summary:</b> ${work.getSummary()}</div>

<%--private boolean complete;--%>
<%--private boolean restricted;--%>

<c:if test="${work.revisedAt != null}"><p><b>Last revised:</b> ${bean.formatDate(work.revisedAt)}</p></c:if>


<%--private long wordCount;--%>
<%--private URL url;--%>
<%--private URL commentUrl;--%>
