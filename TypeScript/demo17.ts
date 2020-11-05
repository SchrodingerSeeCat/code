// 泛型
function join<E>(first: E, second: E) {
    return `${first}${second}`
}
console.log(join<string>("Hello", "World"))
console.log(join<number>(1, 2))

// 泛型是数组
function myFun<E>(params: E[]){
    return params
}

// // 泛型继承
// interface animal{
//     name: string
// }

// class Person<E extends animal>{
//     constructor(private person: E[]){}
//     getName(index: number): string{
//         return this.person[index].name
//     }
// }

// const person = new Person([
//     {name: "小明"},
//     {name: "老王"}
// ])

// 泛型约束
class Person<E extends number | string> {
    constructor(private person: E[]){}
    getName(index: number): E{
        return this.person[index]
    }
}
const person = new Person<string>(["小明", "老王"])
console.log(person.getName(1))