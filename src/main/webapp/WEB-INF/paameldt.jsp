<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/simple.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		${deltager.fornavn}<br />
		${deltager.etternavn}<br />
		${deltager.mobil}<br />
		${deltager.kjonn}
	</p>
	<a href="/deltagerliste">Gå til deltagerlisten</a>
</body>
</html>
