<?php
$username = '';
$password1 = '';
$password2 = '';
$email = '';
if (!empty($_POST)) {
    $username = $_POST['username'];
    $password1 = $_POST['password1'];
    $password2 = $_POST['password2'];
    $email = $_POST['email'];

    // 检查表单元素是否合法
    checkForm();
}

function checkForm() {
    global $username, $password1, $password2, $email;
    if (!preg_match('/^[A-Z][A-Za-z0-9]{7,9}/', $username)) {
        handleError('username', "用户名必须为大写字母开头，并且长度在8-10位");
        return;
    }

    if (!preg_match('/^[A-Za-z][A-Za-z0-9]{7,11}/', $password1)) {
        handleError('password', "密码以字母开头，并且长度在8-12位");
        return;
    }

    if ($password1 != $password2) {
        handleError('两次输入的密码不一致，请重新输入');
        return;
    }

    if (!preg_match('/^([a-zA-Z]|[0-9])(\w|-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/', $email)) {
        handleError('您输入的邮箱不合法');
        return;
    }

    handleError('注册成功');
}
function handleError($type, $msg='') {
    echo "<script>alert('$type $msg')</script>";
    echo "<meta http-equiv=\"refresh\" content=\"0; url=../index.html\">";
}
?>
