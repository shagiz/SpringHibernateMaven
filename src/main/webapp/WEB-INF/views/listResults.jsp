<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
<title>Data</title>
</HEAD>
<BODY>
	<h1>List of data:</h1>
	
	<table cellspacing="30">
		<c:forEach var="listData" items="${requestScope.listDatas}">
			<tr>
			<td><c:out value="${listData.key}" /></td>
			<td><c:out value="${listData.name}" /></td>
			<td><c:out value=" ${listData.price}" /></td>
			<td><c:out value="${listData.date}" /></td>
			</tr>
		</c:forEach>
	</table>
	<BR>
	<li><a href="/home">Main page</a></li>
</BODY>
</HTML>