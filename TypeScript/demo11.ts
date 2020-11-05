// 访问权限
class Person{
    // 如果不指定访问权限，默认public
    name: string
    private age: number
    protected gender: boolean
    public sayHello(){
        console.log(this.name + " Hello")
    }
}

class Teacher extends Person{
    public sayBye(){
        console.log(this.gender)
    }
}

const person = new Person()
person.sayHello()