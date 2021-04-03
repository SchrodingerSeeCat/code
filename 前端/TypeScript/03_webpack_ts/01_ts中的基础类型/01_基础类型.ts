// 基础类型
(() => {
    // 布尔类型 
    // let 变量名:类型 = 值
    let flag:boolean = true;
    console.log(flag)

    // 数字类型
    let a1:number = 10; //十进制
    console.log(a1)

    // 字符串
    let str:string = '字符串'
    console.log(str)

    // 字符串拼接
    let str2:string = str + a1;
    console.log(str2)

    console.log("======================")

    // undefined和null, 需要关闭严格模式
    let und:undefined = undefined;
    let nll:null = null;
    console.log(und)
    console.log(nll)

    // undefined和null都可以作为其他类型的子类性，把undefined和null赋值给其他类型的变量
    let a2:number = und;
    console.log(a2)

    // 数组类型
    let arr1:number[] = [10, 20, 30]
    console.log(arr1)
    // 泛型写法
    let arr2:Array<number> = [30, 40]
    console.log(arr2)

    // 元组类型
    // 类型和数据的个数保持一一对应
    let arr3:[string, number, boolean] = ['小', 100, false]
    console.log(arr3)

    // 枚举类型
    enum Color{
        red,
        green,
        blue
    }

    // 定义一个Color的枚举类型的变量来接受枚举的值
    let color:Color = Color.red
    console.log(color)

    // any类型, 不确定类型
    let str3:any = 100
    str3 = '小爱同学'
    console.log(str3)

    // void类型, 代表该函数没有返回值
    function showMsg() :void{
        console.log('哈哈哈')
    }
    showMsg()

    // object类型
    function getObj(obj:object) : object {
        console.log(obj)
        return {
            name: '卡卡西',
            age: 20
        }
    }
    let obj : object = getObj({name: '漩涡鸣人'})
    console.log(obj)

    // 联合类型表示取值可以为多种类型中的一种
    function getString(str:number|string) : string{
        return str.toString()
    }

    console.log(getString('123'))

    // 类型断言
    function getString2(str:number|string) : number{
        if ((<string>str).length) {
            return (<string>str).length
        }
        return str.toString().length
    }

    console.log(getString2(20))
})()