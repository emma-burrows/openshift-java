<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div><b>Summary:</b> ${work.getSummary()}</div>
<c:if test="${work.notes != ''}"><b>Notes:</b> ${work.notes}</c:if>


<%--private boolean complete;--%>
<%--private boolean restricted;--%>

<c:if test="${work.revised_at != null}"><p><b>Last revised:</b> ${bean.formatDate(work.revised_at)}</p></c:if>


<%--private long word_count;--%>
<%--private URL url;--%>
<%--private URL commentUrl;--%>

<c:if test="${work.endnotes != ''}"><b>End Notes:</b> ${work.endnotes}</c:if>

<a href="${work.comment_url}">Comment on this work at Archive of our Own</a>