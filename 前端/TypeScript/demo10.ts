// class
class Person{
    content = "Hello World"
    sayHello(){
        return this.content
    }
}

// 继承
class Lady extends Person{
    // 重写父类的方法
    sayHello(){
        // 使用super关键字来调用父类中的方法
        return super.sayHello() + "Hi, Hi"
    }
    say() {
        return "I am a women"
    }
}
const xiaoMing = new Person()
console.log(xiaoMing.sayHello())