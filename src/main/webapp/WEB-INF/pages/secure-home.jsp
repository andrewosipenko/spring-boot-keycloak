<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
  <base href="secure-portal/">
</head>
<h1>Welcome to Hogwarts</h1>

<p>
  Dear <sec:authentication property="principal.name"/>!<br>
  Welcome to Hogwarts secure portal.
</p>

<p>
  View <a href="students">students</a> or <a href="teachers">teachers</a>
</p>

<p>
  <a href="/logout">Logout</a>
</p>