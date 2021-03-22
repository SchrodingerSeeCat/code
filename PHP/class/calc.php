<?php
$firstNum = ""; // 第一个操作数
$secondNum = ""; // 第二个操作数
$operation = ""; // 操作符
$result = ""; // 返回值
$error = false; // 是否出错
if(isset($_POST["firstNum"]) && isset($_POST["secondNum"])) {
    // 字符串用于页面展示
    $firstNum = (float)$_POST["firstNum"];
    $secondNum = (float)$_POST["secondNum"];

    // 数字用于计算
    $first = (float)$_POST["firstNum"];
    $second = (float)$_POST["secondNum"];
    $operation = $_POST["operation"];

    switch ($operation) {
        case "+":
            $result = ($first + $second);
            break;
        case "-":
            $result = ($first - $second);
            break;
        case  "*":
            $result = ($first * $second);
            break;
        case "/":
            // 除数不能为空
            if($second == 0) {
                // 设置出错标志，并清空所有已存储的值
                $error = true;
                $firstNum = "";
                $secondNum = "";
                $result = "";
                break;
            }
            $result = ($first / $second);
    }
}
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>简单计算器</title>
    </head>
    <style>
        form{
            position:fixed;
            width:350px;
            height:120px;
            top:0;
            right:0;
            bottom:0;
            left:0;
            margin:auto;
            padding-left: 30px;
            border: 1px solid #D5D5D5;
        }
        input{
            width: 100px;
        }
    </style>
    <body>
        <form action="calc.php" method="post">
            <h3>简单计算器</h3>
            <input
                name="firstNum"
                value="<?php print $firstNum?>"
                autocomplete="off"
                placeholder="first number"
                type="number">
            <select name="operation" id="select">
                <option>+</option>
                <option>-</option>
                <option>*</option>
                <option>/</option>
            </select>
            <input
                name="secondNum"
                value="<?php print $secondNum?>"
                autocomplete="off"
                placeholder="second number"
                type="number">
            <button>=</button>
            <span class="result">
                <?php
                    if($error) {
                        print "<br/>参数错误，请重新输入";
                    } else {
                        print $result;
                    }
                ?>
            </span>
        </form>
    </body>
    <script type="text/javascript">
        // 使用js选择默认的运算符
        let select=document.getElementById('select') //得到select的ID
        let options=select.getElementsByTagName('option') //得到数组option

        let operation = '<?php print $operation; ?>'
        switch (operation) {
            case "+":
                options[0].selected = true;
                break;
            case "-":
                options[1].selected = true;
                break;
            case  "*":
                options[2].selected = true;
                break;
            case "/":
                options[3].selected = true;
        }
    </script>
</html>