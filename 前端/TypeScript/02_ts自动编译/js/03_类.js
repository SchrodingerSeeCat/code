"use strict";
// ts类的演示
(function () {
    // 定义一个类
    var Person = /** @class */ (function () {
        // 定义一个构造器
        function Person(firstName, lastName) {
            // 更新属性数据
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = firstName + "." + lastName;
        }
        return Person;
    }());
    // 定义一个函数
    function showFullName(person) {
        return person.firstName + "_" + person.lastName;
    }
    // 实例化对象
    var person = new Person('诸葛', '孔明');
    console.log(showFullName(person));
})();
