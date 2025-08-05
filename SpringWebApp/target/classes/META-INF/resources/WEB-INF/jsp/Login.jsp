<html>
<head>
    <title>Login Screen</title>
</head>
<body>
<%--<h1>Welcome ${name}</h1>--%>

<div class="container">
    <h1>Welcome to Login Page</h1>
    <pre>${errMessage}</pre>
<form  method="post">
    <label for="name">Name: </label>
    <input type="text" name="name">
    <label for="password">Password: </label>
    <input type="password" name="password">
    <input type="submit">
</form>
    </div>
</body>
</html>