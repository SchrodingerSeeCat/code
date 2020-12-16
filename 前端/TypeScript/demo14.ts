// 只读属性
// class Person{
//     public readonly _name: string
//     constructor(name: string) {
//         this._name = name
//     }
// }

// const person = new Person("小明")
// console.log(person._name)

// 抽象类
abstract class Person {
    abstract skill(): void
}

class Teacher extends Person {
    skill(){
        console.log("我会上课")
    }
}

class Police extends Person{
    skill(){
        console.log("我是警察")
    }
}