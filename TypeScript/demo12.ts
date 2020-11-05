// 构造函数
class Person{
    constructor(private name:string){
    }
    public sayName(){
        console.log(this.name)
    }
}

class Teacher extends Person{
    constructor(name: string, private hobby: string){
        super(name)
    }
}
const person = new Person("老王")
person.sayName()
const teacher = new Teacher("小明", "打篮球")
