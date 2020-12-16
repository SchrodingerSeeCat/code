// 接口
interface Girl{
    name: string
    age: number
    height: number
    // 问号表明weight可有可无
    weight ? : number
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
    height: 180
}
screenResume(girl)