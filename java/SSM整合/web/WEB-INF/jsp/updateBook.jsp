<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12">
            <h1>
                <small>修改书籍</small>
            </h1>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="POST">
        <%--隐藏域传递id--%>
        <input type="hidden" name="bookID" value="${QBooks.bookID}">
        <div class="form-group">
            <label for="book-name">书籍名称</label>
            <input type="text" name="bookName" class="form-control" id="book-name" placeholder="书籍名称" value="${QBooks.bookName}" required>
        </div>
        <div class="form-group">
            <label for="book-count">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" id="book-count" placeholder="书籍数量" value="${QBooks.bookCounts}" required>
        </div>
        <div class="form-group">
            <label for="book-detail">书籍描述</label>
            <input type="text" name="detail" class="form-control" id="book-detail" placeholder="书籍描述" value=${QBooks.detail} required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="确定">
        </div>
    </form>
</div>
</body>
</html>
