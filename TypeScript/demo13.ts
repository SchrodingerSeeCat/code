// Getter Setter static
class Person{
    // 要返回的属性必须以 `_`开头
    constructor(private _name: string, private _age: number){}
    get age(){
        return this._age
    }
    get name(){
        return this._name
    }

    set age(age: number){
        this._age = age
    }
    // 静态方法
    static sayHello(){
        return "Hello"
    }
}

const xiaoMing = new Person("小明", 18)
xiaoMing.age = 29
console.log(xiaoMing.age)

// 静态方法可以通过对象名.方法名调用
console.log(Person.sayHello())