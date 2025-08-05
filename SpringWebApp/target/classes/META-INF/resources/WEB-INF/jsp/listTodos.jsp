<%@include file="common/Header.jspf" %>
<%@include file="common/Navigation.jspf" %>
<h1>Welcome ${name}</h1>
<hr>
<div class="container">

<h2>Your Todos</h2>
<table border="1" clas="table">
    <thead>
    <tr>
<%--        <th>Id</th>--%>
        <th>Name</th>
        <th>Description</th>
        <th>Target Date</th>
        <th>Status</th>
        <th></th>
        <th></th>
    </tr>

    </thead>

    <tbody>
    <c:forEach items="${todo}" var="todo">
        <tr>
<%--        <td>${todo.id}</td>--%>
        <td>${todo.username}</td>
        <td>${todo.description}</td>
        <td>${todo.targetDate}</td>
        <td>${todo.isDone}</td>
            <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete </a></td>
            <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">Update </a></td>
        </tr>

    </c:forEach>
    </tbody>

</table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@include file="common/Footer.jspf" %>