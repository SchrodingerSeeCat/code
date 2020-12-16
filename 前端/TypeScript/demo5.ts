// 指定函数的返回值类型
function getTotal(one: number, two: number) : number{
    return one + two
}
const total = getTotal(1 , 2)
console.log(total)

// 函数无返回值，指定为 void
function sayHello() : void{
    console.log("Hello World")
}

// 如果一个函数的某些部分永远无法被执行，那么应该注解为never
function errorFunction() : never{
    throw new Error("下面的代码不可能被执行到")
    console.log("Hello World")
}

// 参数为对象，应该在对象的后面追加对象注解
function add({one, two} : {one: number, two: number}) : number{
    return one + two
}
const total2 = add({one: 1, two: 2})