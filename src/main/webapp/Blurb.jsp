<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div><b>Summary:</b> ${work.getSummary()}</div>

<%--private boolean complete;--%>
<%--private boolean restricted;--%>

<c:if test="${work.revised_at != null}"><p><b>Last revised:</b> ${bean.formatDate(work.revised_at)}</p></c:if>


<%--private long word_count;--%>
<%--private URL url;--%>
<%--private URL commentUrl;--%>
