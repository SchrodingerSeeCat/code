// 接口 二
interface Girl{
    name: string
    age: number
    height: number
    // 问号表明weight可有可无
    weight ? : number
    // 表示可以放入接口中没有的字段
    [propname:string]:any
    // 方法
    say():string
}
const screenResume = (girl:Girl) => {
    if (girl.age < 24 && girl.height > 170) {
        console.log("进入面试")
        return
    }
    console.log("你被淘汰")
}
const girl = {
    name: "小红",
    age: 18,
    height: 180,
    sex: "女",
    say():string {
        return "Hello World"
    } 
}
screenResume(girl)

class Person implements Girl {
    name: string
    age: number
    height: number
    say(){
        return "I am person"
    }
}

interface Teacher extends Girl {
    teach():string
}