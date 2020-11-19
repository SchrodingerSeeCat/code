# TypeScript

## 环境搭建

安装`typescript`

```cmd
npm install typescript -g
```

新建`demo.ts`编写`demo`

```typescript
function hello() {
    let web: string = "Hello World"
    console.log(web)
}
hello()
```

编译`demo.ts`为`demo.js`

```
tsc demo.ts
```

运行`demo.js`

```
node demo.js

// Hello World
```

安装`ts-node`

```
npm install -g ts-node
```

直接运行`demo.ts`

```cmd
ts-node demo.ts

// Hello World
```

## tsconfig.json

### 作用

`typescript`的编译配置文件

### 生成

进入`typescript`的项目目录使用

```cmd
tsc -init
```

在配置文件的第二行添加

```json
"include": ["要编译的ts文件"]
// 第二种写法
"exclude": ["不需要编译的ts文件"]
```

在`命令行中`

```
tsc
```

会自动生成相应的`js`文件

### compilerOptions 选项

严格按照`typescript`的语法书写

```json
"strict": true
```

编译是否编译注释

```json
"removeComments": true, 
```

表明需要类型注解

```typescript
"noImplicitAny": true
```

不允许有`null`出现

```json
"strictNullChecks": true
```

源文件目录

```json
"rootDir": "./"
```

编译后的`js`文件目录

```json
"outDir": "./"
```

生成源代码到编译后代码的映射

```json
"sourceMap": true
```

检查未使用的变量

```json
"noUnusedLocals": true
```

检查未使用的方法

```json
"noUnusedParameters": true
```

## Static Typing(静态类型)

### 快速入门

 静态类型,typescript有变量类型

```typescript
const count : number = 10
```

自定义类型

```typescript
 interface XiaoJieJie{
    name: string,
    age: number
}

const xiaoHong: XiaoJieJie = {
    name: "小红",
    age: 18
}
```

### 基础静态类型

基础静态类型有`number`,`string`,`null`,`undefined`,`boolean`,`void`,`symbol`

用法

```typescript
// number
const count: number = 11
// string
const myName: string = "GG bob"
```

### 对象静态类型

形式一(对象类型)

```typescript
const xiaoJiejie : {
    name: string,
    age: number
} = {
    name: "小红",
    age: 18
}
```

形式二(数组)

```typescript
const xiaoJiejies: string[] = ["程潇", "杨超越"]
```

形式三(类类型)

```typescript
class Person{}
const dajiao: Person = new Person()
```

形式四(函数类型)

```typescript
const jianXiaoJieJie: ()=>string = ()=>{
    return "bob"
}
```

## 类型注解，类型断言

### 类型注解

在定义变量时标注变量的类型，称为类型注解

```typescript
let age:number
```

### 类型断言

在定义时不标注变量的类型，称为类型断言

```typescript
let word = "Hello World"
```

### 函数注解

在定义函数时，其参数和返回值可以指定注解

```typescript
function getTotal(one: number, two: number) : number{
    return one + two
}
const total = getTotal(1 , 2)
console.log(total)
```

如果没有返回值建议返回值注解为`void`

```typescript
function sayHello() : void{
    console.log("Hello World")
}
```

如果一个函数的某些部分永远无法被执行，那么应该注解为never

```typescript
function errorFunction() : never{
    throw new Error("下面的代码不可能被执行到")
    console.log("Hello World")
}
```

参数为对象，应该在对象的后面追加对象注解

```typescript
function add({one, two} : {one: number, two: number}) : number{
    return one + two
}
const total = add({one: 1, two: 2})
```

### 数组注解

单类型数组

```typescript
const array: number[] = [1, 2, 3]
```

多类型数组

```typescript
const array: (number | string)[] = [1, "string", 3]
```

类型别名(`type alias`)

```typescript
type Lady = {name: string, age: number}
const array3: Lady[] = [
    {name: "haha", age: 18}
]
```

## 元组

元组，元组规定了数组内的元素类型的顺序

```typescript
const student: [string, string, number] = ["xxx02345", "小明", 18]
```

## 接口(interface)

### 定义

```typescript
interface Girl{
    name: string
    age: number
    height: number
    // 问号表明weight可有可无
    weight ? : number
    // 表示可以放入接口中没有的字段
    [propname:string]:any
    // 方法
    say():string
}
```

### 使用

```typescript
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
    height: 180,
    sex: "女",
    say():string {
        return "Hello World"
    }
}
screenResume(girl)
```

### 类实现接口

```typescript
class Person implements Girl {
    name: string
    age: number
    height: number
    say(){
        return "I am person"
    }
}
```

### 接口继承

```typescript
interface Teacher extends Girl {
    teach():string
}
```

## 类(class)

### 快速入门

```typescript
class Person{
    content = "Hello World"
    sayHello(){
        return this.content
    }
}

const xiaoMing = new Person()
console.log(xiaoMing.sayHello())
```

### 继承

子类会继承父类的所有(非私有)字段和方法

```typescript
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
```

### 访问权限

```typescript
class Person{
    name: string
    private age: number
    protected gender: boolean
    public sayHello(){
        console.log(this.name + " Hello")
    }
}
```

如果不指定访问权限，默认`public`,`public`可以在任何地方进行访问

`private`成员外部以及其子类不能直接访问

`protected`成员类似`private`但可以在子类中进行访问

### 构造函数

方式一

```typescript
class Person{
    private name: string
    constructor(name:string){
        this.name =  name
    }
}

const person = new Person("老王")
```

方式二

```typescript
class Person{
    constructor(private name:string){}
}

const person = new Person("老王")
```

对于子类而言`constructor`必须调用父类的`constructor`

如果子类中没有`constructor`使用一个空的`super()`

```typescript
class Teacher extends Person{
    constructor(name: string, private hobby: string){
        super(name)
    }
}

const teacher = new Teacher("小明", "打篮球")
```

### Getter Setter static

对于私有属性和保护属性而言，在类的内部定义`get`方法返回属性

```typescript
class Person{
    constructor(private name: string, private _age: number){}
    get age(){
        return this._age
	}
    set age(age: number){
        this._age = age
    }
    // 静态方法
    static sayHello(){
        return "Hello"
    }
}
// 在类的外部可直接通过 对象.属性名 返回对应的值
const xiaoMing = new Person("小明", 18)
console.log(xiaoMing.age) // 18

xiaoMing.age = 29
console.log(xiaoMing.age) // 29

// 静态方法(属性)可以通过对象名.方法名调用
console.log(Person.sayHello())
```

`get`要返回的属性必须以 `_`开头

`set`方法必须接受一个参数

### readonly

只读属性

```typescript
class Person{
    public readonly _name: string
    constructor(name: string) {
        this._name = name
    }
}
```

### 抽象类

```typescript
abstract class Person{
    abstract skill()
}

class Teacher extends Person{
    skill(){
        console.log("我会上课")
    }
}

class Police extends Person{
    skill(){
        console.log("我是警察")
    }
}
```

## 联合类型和类型保护

### 类型守护

如果一个函数的参数的注解有多个，那么它就是`联合类型`

```typescript
interface Watier{
    massage: boolean
    say:()=>{}
}
interface Teacher{
    massage: boolean
    skill:()=>{}
}

function judgeWho(animal: Watier | Teacher) {
    
}
```

### 类型保护

- 类型断言一

  ```typescript
  function judgeWho(animal: Watier | Teacher) {
      if(animal.massage) {
          // 类型断言
          (animal as Watier).say()
      } else {
          (animal as Teacher).skill()
      }
  }
  ```

- 类型断言二

  ```
  function judgeWho(animal: Watier | Teacher) {
      if('say' in animal) {
          (animal as Watier).say()
      } else {
          (animal as Teacher).skill()
      }
  }
  ```

- `typeof`

  ```typescript
  // typeof
  function add(first: string | number, second: string | number) {
      if (typeof first === "string" && typeof second === "string") {
          return `${first}${second}`
      }
      if (typeof first === "number" && typeof second === "number") {
          return first + second
      }
      return null
  }
  ```

- `instanceof`

  ```typescript
  class Person{
      count: number
  }
  function addObj(first: object | Person, second: object | Person) {
      if (first instanceof Person && second instanceof Person) {
          return first.count + second.count
      }
      return 0
  }
  ```

## 枚举`enum`

```
enum Status{
    MASSAGE, SPA, DA_BAO_JIAN
}

function getServe(status: any) {
    if (status == Status.MASSAGE) {
        return "massage"
    }
    if (status == Status.SPA) {
        return "SPA"
    }
    if (status == Status.DA_BAO_JIAN){
        return "dabaojian"
    }
    return null
}
```

枚举的的值默认从`0`开始，可以重新赋值设定初始值

## 泛型

函数泛型

```typescript
function join<E>(first: E, second: E) {
    return `${first}${second}`
}
console.log(join<string>("Hello", "World"))
console.log(join<number>(1, 2))

// 数组
function myFun<E>(params: E[]){
    return params
}
```

泛型可以定义多个泛型

类泛型

```typescript
class Person<E>{
    constructor(private person: E[]){}
    getName(index: number): E{
        return this.person[index]
    }
}

const person = new Person<string>(["小明", "老王"])
```

泛型继承

```typescript
class Person<E extends animal>{
    constructor(private person: E[]){}
    getName(index: number): string{
        return this.person[index].name
    }
}

const person = new Person([
    {name: "小明"},
    {name: "老王"}
])
```

泛型约束

```typescript
class Person<E extends number | string> {
    constructor(private person: E[]){}
    getName(index: number): E{
        return this.person[index]
    }
}
const person = new Person<string>(["小明", "老王"])
console.log(person.getName(1))
```

## 命名空间

### 创建项目流程

1. 生成`package.json`

   ```
   npm init -y
   ```

2. 生成`tsconfig.json`

   ```
   tsc -init
   
   # 更改 
   # "outDir": "./build"
   # "rootDir": "./src"
   ```

3. 新建`src`与`build`文件夹

4. 新建`index.html`文件

### 命名空间

```typescript
namespace 名字{
	// 代码
}
```

对于多个`ts`文件生成的多个`js`文件可以配置`tsconfig.json`

```json
"outFile": "./build/page.js"

// 并修改 "module": "commonjs"
"module": "amd"
```

命名空间支持嵌套定义

```typescript
namespace Out{
	export namespace In{
		
	}
}
```

### import的用法

```typescript
import { 导入的变量/函数/类 } from "./components"
```

导入`require.js`

```html
<script src="https://cdnjs.cloudflare.com/ajax/libs/require.js/2.3.6/require.js"></script>
```

注意编译后的`ts`默认抛出的变量是小写

```html
<script>
	require(["page"], function(page){
		new page.default()
	})
</script>
```

## parcel打包

### 安装

```cmd
npm install -d parcel
```

### 配置

打开`package.json` 找到`scripts`修改

```json
"test": "parcel ./src/index.html"
```

### 打包

```
npm run test
```

打包后的文件都在`dist`文件夹下

## Ts使用jquery

1. 声明`$`为`any`

   ```
   declare var $:any
   ```

2. 安装`@types/jquery`

   ```
   npm install @types/jquery
   ```

   