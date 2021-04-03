"use strict";
// 类型注解：是一种轻量级的为函数或者变量添加的约束
(function () {
    function showMsg(str) {
        return "床前明月光, " + str;
    }
    var msg = "疑是地上霜";
    var num = 50;
    console.log(showMsg(msg));
    // console.log(showMsg(num)); // 不能传入除string以外的类型
})();
