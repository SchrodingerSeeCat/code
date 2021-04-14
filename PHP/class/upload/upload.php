<?php
if (!empty($_FILES)) {
    foreach($_FILES['files']['name'] as $key => $str) {
        if ($str == '') {
            if ($key == 0) {
                jumpIndex('未指定任何文件，请重新上传', 0);
                return;
            } else {
                jumpIndex('未指定全部文件或者文件有重复，请重新上传', 0);
                return;
            }
        } else if (!preg_match('/(\.(png)|(jpeg)|(jpg))$/', $str)){
            jumpIndex('文件格式必须为PNG或者JPG.请重新上传', 0);
            return;
        }
    }
    if (!file_exists('./uploadedfile')) {
        mkdir('./uploadedfile');
    }
    foreach($_FILES['files']['name'] as $key => $file_name) {
        move_uploaded_file($_FILES['files']['tmp_name'][$key], "./uploadedfile/$file_name");
    }
    jumpIndex('上传成功, 即将返回主页');
} else {
    jumpIndex('无效的请求', 0);
}

function jumpIndex($msg, $time = 3) {
    echo "<script>alert('$msg')</script>";
    echo "<meta http-equiv=\"refresh\" content=\"$time; url=index.html\">";
}