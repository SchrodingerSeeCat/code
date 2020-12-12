<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12">
            <h1>
                <small>新增书籍</small>
            </h1>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/addBook" method="POST">
        <div class="form-group">
            <label for="book-name">书籍名称</label>
            <input type="text" name="bookName" class="form-control" id="book-name" placeholder="书籍名称" required>
        </div>
        <div class="form-group">
            <label for="book-count">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" id="book-count" placeholder="书籍数量" required>
        </div>
        <div class="form-group">
            <label for="book-detail">书籍描述</label>
            <input type="text" name="detail" class="form-control" id="book-detail" placeholder="书籍描述" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>
    </form>
</div>
</body>
</html>
