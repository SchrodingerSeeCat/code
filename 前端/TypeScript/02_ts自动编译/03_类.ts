// ts类的演示
(() => {
    // 定义一个接口
    interface IPerson{
        firstName: string // 姓氏
        lastName: string // 名字
    }

    // 定义一个类
    class Person implements IPerson{
        firstName: string // 姓氏
        lastName: string // 名字
        fullName: string

        // 定义一个构造器
        constructor(firstName: string, lastName: string) {
            // 更新属性数据
            this.firstName = firstName
            this.lastName = lastName
            this.fullName = firstName + "." + lastName
        }
    }

    // 定义一个函数
    function showFullName(person : IPerson) {
        return person.firstName + "_" + person.lastName
    }

    // 实例化对象
    const person = new Person('诸葛', '孔明')
    console.log(showFullName(person))
})()