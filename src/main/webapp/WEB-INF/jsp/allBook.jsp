
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="page-header">
        <h3 class="text-center">
            书籍列表 —— 显示所有书籍
        </h3>
    </div>
    <div class="col-md-4 column">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询所有书籍</a>
    </div>

    <div class="col-md-4 column">
        <%--查询书籍--%>
        <form action="${pageContext.request.contextPath}/book/queryBookByName" method="post" class="form-inline">
            <span style="color: red;font-weight: bold;">${error}</span>
            <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称">
            <input type="submit" class="btn btn-primary" value="查询">
        </form>
    </div>

    <div class="col-md-4 column">
        <%--模糊查询书籍--%>
        <form action="${pageContext.request.contextPath}/book/queryBook" method="post" class="form-inline">
            <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称">
            <input type="submit" class="btn btn-primary" value="模糊查询">
        </form>
    </div>


    <div class="col-md-12 column">
        <table class="table table-hover table-striped table-bordered">
            <thead>
            <tr class="warning">
                <th>书籍编号</th>
                <th>书籍名字</th>
                <th>书籍数量</th>
                <th>书籍详情</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="book" items="${requestScope.get('list')}">
                <tr  class="info ">
                    <td>${book.getBookID()}</td>
                    <td>${book.getBookName()}</td>
                    <td>${book.getBookCounts()}</td>
                    <td>${book.getDetail()}</td>
                    <td>
                        <a class="btn btn-info" href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.getBookID()}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>更改</a> |
                        <a  class="btn btn-danger"  href="${pageContext.request.contextPath}/book/del/${book.getBookID()}">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>