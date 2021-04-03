// 接口是一种类型，是一种规范，是一种约束

(() => {
    /**
     * id number类型，必须有，只读的
     * name string类型，必须的
     * age number类型，必须有
     * sex boolean类型，可以没有
     */
    interface Person{
        // readonly只读的
        readonly id: number
        name: string
        age: number
        // ?表示可以没有
        sex?: boolean
    }

    const person: Person = {
        id: 1,
        name: "王二狗",
        age: 18,
        sex: true
    }
})()