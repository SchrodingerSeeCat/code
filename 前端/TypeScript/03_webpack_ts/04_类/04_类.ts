(() => {
    interface Person{
        name: string
        age: number
        fly()
    }

    interface Skill{
        swim()
    }

    class PersonImpl implements Person, Skill{
        name: string
        age: number
        
        constructor(name: string = '', age: number = 10) {
            this.name = name
            this.age = age
        }
        fly() {
            console.log(this.name + '会飞了')
        }

        swim() {

        }
    }
    const person : PersonImpl = new PersonImpl('hhhhh')
    person.fly()
})()