// 存取器：让我们可以有效的控制对象中的成员的访问，通过getters和setters进行操作
(() => {
    class Person{
        private firstName: string // 姓氏
        private lastName: string // 名字
        
        constructor(firstName: string = '', lastName: string = '') {
            this.firstName = firstName
            this.lastName = lastName
        }

        get fullName(){
            return this.firstName + this.lastName
        }

        set fullName(value){
            this.fullName = value
        }
    }


    const person: Person = new Person('蒋', '文浩')
    console.log(person)
})()