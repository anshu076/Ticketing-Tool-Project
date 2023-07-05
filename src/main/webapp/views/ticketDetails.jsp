<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>
<h1> ***** Ticket details are below!*****</h1>

<br>

<form action="view">
<br>

Ticket id is          : ${ticketInfo.ticketId} <br>
Ticket description is : ${ticketInfo.ticketDesc} <br>
Ticket date is        : ${ticketInfo.ticketDate} <br>
Project mapped is     : ${ticketInfo.projId} <br>

<br>

<input type="submit" value="Click here to retrieve tickets" />

</form>

</body>
</html>