// 基础静态类型
// number
const count: number = 11
// string
const myName: string = "GG bob"

// 对象静态类型
const xiaoJiejie: {
    name: string,
    age: number
} = {
    name: "小红",
    age: 18
}
// 数组
const xiaoJieJies: string[] = ["程潇", "杨超越"]

// 对象类型
class Person{}
const dajiao: Person = new Person()

// 函数类型
const jianXiaoJieJie: ()=>string = ()=>{
    return "bob"
}