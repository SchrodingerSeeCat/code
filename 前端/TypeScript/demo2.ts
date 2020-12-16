// 静态类型,typescript有变量类型
const count : number = 10

// 自定义类型
interface XiaoJieJie{
    name: string,
    age: number
}

const xiaoHong: XiaoJieJie = {
    name: "小红",
    age: 18
}
console.log(xiaoHong.age)