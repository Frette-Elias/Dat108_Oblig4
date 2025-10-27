<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/simple.css">
	<title>Deltagerliste</title>
</head>
<body>
    <p id="innloggetSom">Innlogget som: <c:out value="${mobil} / ${fornavn} ${etternavn}"/></p>

	<h2>Deltagerliste</h2>
	<table>
			<tr>
				<th>Kjønn</th>
				<th align="left">Navn</th>
				<th align="left">Mobil</th>
			</tr>
            <c:forEach var="deltager" items="${deltagere}">
            <tr>
                <td align="center">${deltager.kjonn == 'Mann' ? '&#9794;' : '&#9792;'}</td>
				<td>${deltager.fornavn}&nbsp;${deltager.etternavn}</td>
				<td>${deltager.mobil}</td>
			</tr>
            </c:forEach>

	</table>

    <form action="logout" method="post">
            <p><input type="submit" value="logout"/> </p>
    </form>

</body>
</html>