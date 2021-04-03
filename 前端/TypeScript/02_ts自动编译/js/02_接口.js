"use strict";
// 接口：约束
(function () {
    // 输出姓名
    function showFullName(person) {
        return person.firstName + " " + person.lasName;
    }
    var person = {
        firstName: "朱",
        lasName: "李宁"
    };
    console.log(showFullName(person));
})();
