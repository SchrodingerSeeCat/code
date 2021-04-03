// 接口：约束
(() => {

    // 定义一个接口
    interface Person{
        firstName : string // 姓氏
        lasName : string // 名字
    }

    // 输出姓名
    function showFullName(person : Person) {
        return person.firstName + " " + person.lasName
    }

    const person = {
        firstName : "朱", 
        lasName: "李宁"
    }
    console.log(showFullName(person))
})()