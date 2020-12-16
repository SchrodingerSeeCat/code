// 联合类型 类型守护
interface Watier{
    massage: boolean
    say:()=>{}
}
interface Teacher{
    massage: boolean
    skill:()=>{}
}

// 类型断言一
function judgeWho(animal: Watier | Teacher) {
    if(animal.massage) {
        (animal as Watier).say()
    } else {
        (animal as Teacher).skill()
    }
}

// // 类型断言二
// function judgeWho(animal: Watier | Teacher) {
//     if('say' in animal) {
//         (animal as Watier).say()
//     } else {
//         (animal as Teacher).skill()
//     }
// }

// typeof
function add(first: string | number, second: string | number) {
    if (typeof first === "string" && typeof second === "string") {
        return `${first}${second}`
    }
    if (typeof first === "number" && typeof second === "number") {
        return first + second
    }
    return null
}

// instanceof
class Person{
    count: number
}
function addObj(first: object | Person, second: object | Person) {
    if (first instanceof Person && second instanceof Person) {
        return first.count + second.count
    }
    return 0
}