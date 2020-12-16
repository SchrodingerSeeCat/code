// 数组注解
const array: number[] = [1, 2, 3]

// 多类型数组
const array2: (number | string)[] = [1, "string", 3]

// type alias类型别名 
type Lady = {name: string, age: number}
class Madam{
    name: string
    age: number
}
const array3: Lady[] = [
    {name: "haha", age: 18}
]