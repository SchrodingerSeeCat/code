<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>文件上传</title>
    <style>
        form {
            width: 100%;
            height: 100%;
            margin-top: 200px;
            text-align: center;
        }
        .file > input {
            width: 200px;
        }
        .submit{
            width: 100%;
        }
    </style>
</head>

<body>
<form action="./upload.php" method="post" enctype="multipart/form-data">
    <div class="file">
        内容一：<input type="file" name="files[]">
    </div>
    <div class="file">
        内容二：<input type="file" name="files[]">
    </div>
    <div class="file">
        内容三：<input type="file" name="files[]">
    </div>
    <div class="file">
        内容四：<input type="file" name="files[]">
    </div>
    <div class="file">
        内容五：<input type="file" name="files[]">
    </div>
    <div class="submit">
        <input type="submit" value="提交">
    </div>
</form>
</body>

</html>