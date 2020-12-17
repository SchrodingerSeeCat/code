# React

[TOC]

## 1. React入门

- `React`使用虚拟`DOM`，不总是直接操作页面的真实`DOM`，以至于会比较高效
- 使用`DOM Diffing`算法，最小化页面重绘

### 1.1 React的基本使用

#### 1.1.1 相关js库

1. `react.js`：`React`核心库
2. `react-dom.js`：提供操作`DOM`的`react`扩展库
3. `babel.min.js`：解析`JSX`语法转换为`JS`代码的库

#### 1.1.2 创建虚拟DOM

**jsx创建虚拟DOM**:star:

1. 创建`index.html`并准备“容器”

   ```
   <div id="test"></div>
   ```

2. 引入`react`依赖库

   ```html
   <!-- 引入react和核心库 -->
   <script type="text/javascript" src="../js/16.x/react.development.js"></script>
   <!-- 引入react-dom，用于支持react操作DOM -->
   <script type="text/javascript" src="../js/16.x/react-dom.development.js"></script>
   <!-- 引入babel，用于将jsx转化为js -->
   <script type="text/javascript" src="../js/16.x/babel.min.js"></script>
   ```

3. 编写`jsx`

   ```html
   <script type="text/babel">
       // 1. 创建虚拟DOM
       const VDOM = <h1>Hello React</h1> // jsx不需要加引号
   
       // 2. 渲染虚拟DOM到页面 
       ReactDOM.render(VDOM, document.getElementById("test"))
   </script>
   ```

   `render`默认为覆盖不是追加

**js创建虚拟DOM**

```html
<script type="text/javascript">
    const VDOM = React.createElement("h1", {id: "title"}, "Hello React") 

    ReactDOM.render(VDOM, document.getElementById("test"))
</script>
```

对于多层级的虚拟`DOM`，`js`就会显得十分繁琐，`jsx`挺身而出

#### 1.1.3 虚拟DOM与真实DOM

1. `React`提供了一些`API`来创建一种 “特别” 的一般js对象

   ```jsx
   const VDOM = (
       <h1 id="test">
       <span>Hello React</span>
       </h1>
   )
   ```

   上面创建的就是一个简单的虚拟`DOM`对象

   虚拟`DOM`的本质是`Object`类型的对象

   虚拟`DOM`相比真实`DOM`属性会少很多

2. 虚拟`DOM`对象最终都会被`React`转换为真实的`DOM`

3. 我们编码时基本只需要操作`react`的虚拟`DOM`相关数据, `react`会转换为真实`DOM`变化而更新界。

### 1.2 React Jsx

#### 1.2.1 简介

1. `jsx`全称`JavaScript XML`

2. `react`定义的一种类似于`XML`的`JS`扩展语法

3. 本质是`React.createElement(Component, props, ...children)`方法的语法糖

4. 作用：用来简化创建虚拟`DOM`

   写法

   ```jax
   var ele = <h1>Hello JSX</h1>
   ```

   它不是字符串，也不是`HTML/XML`标签

   它最终产生的就是一个`js`对象

5. 标签名任意：`HTML`标签或其他标签

#### 1.2.2 基本语法

1. 定义`DOM`是，不要写引号

2. 如果说标签内的内容是一个变量则需要`{}`进行取值

   ```html
   <script type="text/babel">
       // 1. 创建虚拟DOM
       const id = "haha"
       const data = "Hello React"
       const VDOM = (
           <h2 id={id}>
           	<span>{data}</span>
           </h2>
       )
   
       // 2.渲染虚拟DOM到页面
       ReactDOM.render(VDOM, document.getElementById("test"))
   </script>
   ```

3. 样式的类名指定不能用`class`，要用`className`

   ```html
   <style>
       .title{
           background-color: orange;
           width: 200px;
       }
   </style>
   <script type="text/babel">
       const VDOM = (
           <h2 className="title">
           	<span>"Hello React"</span>
           </h2>
       )
   
       ReactDOM.render(VDOM, document.getElementById("test"))
   </script>
   ```

4. 内敛样式需要使用`{{}}`，且如果是`font-size`这样有两个单词组成的需要用驼峰命名法

   ```html
   <script type="text/babel">
       const VDOM = (
           <h2>
           	<span style={{color: 'red', fontSize: '30px'}}>"Hello React"</span>
           </h2>
       )
   
       ReactDOM.render(VDOM, document.getElementById("test"))
   </script>
   ```

5. `jsx`只能有一个根标签

6. 标签必须闭合

   ```html
   <script type="text/babel">
       const VDOM = (
           <h2>
           	<input type="text" />
           </h2>
       )
   
       ReactDOM.render(VDOM, document.getElementById("test"))
   </script>
   ```

7. 首字符小写标签仅能为`html`的标准标签，首字符大写是一个自定义的组件

#### 1.2.3 练习

`jsx`动态渲染数据

- 表达式：一个表达式会产生一个值，可以放在任何一个需要值的地方

  变量

  函数。。。

- 语句(代码)：

  `if`语句，`for`语句

- 对于`jsx`内部的`{}`只能为表达式

```html
<div id="test"></div>
<script type="text/babel">
// 模拟后端数据
const data = ["Angular", "React", "Vue"]
const VDOM = (
	<div>
		<h1>前端js框架列表</h1>    
		<ul>
			{
				data.map((item, index) => {
					return <li key={index}>{item}</li>
				})
			}   
    	</ul>
    </div>
    )
	ReactDOM.render(VDOM, document.getElementById("test"))
</script>
```

每一个虚拟`DOM`节点，都需要一个`key`用来作为唯一标识

### 1.3 模块与组件、模块化与组件化

#### 1.3.1 模块

1. 理解：向外部提供特定功能的`js`程序，一般就是一个`js`文件
2. 为什么要拆分模块：随着业务逻辑的增加，代码越来越多且复杂
3. 作用：复用`js`，简化`js`的编写，提高`js`运行效率

#### 1.3.2 组件

1. 理解：用来实现局部功能效果的代码和资源的集合`html/css/js/image`等等
2. 为什么需要组件：一个界面的功能太过复杂
3. 作用：复用编码，简化项目编码，提高运行效率

#### 1.3.3 模块化

当应用的`js`都已模块来编写的，这个应用就是一个模块化的应用

#### 1.3.4 组件化

当应用是以多组件的方式实现的，这个应用就是一个组件化的应用

## 2. React面向组件开发

### 2.1 基本理解和使用

#### 2.1.1 使用React开发者工具调试

安装插件`React Developer Tools`

#### 2.1.2 组件的创建方式

**函数式组件**

```html
<div id="test"></div>
<script type="text/babel">
    // 1. 创建函数式组件
    function MyComponent() {
        return (
            <h1>函数式组件，适用于简单组件的定义</h1>
        )
    }

    // 2. 渲染组件到页面
    ReactDOM.render(<MyComponent />, document.getElementById("test"))
</script>
```

函数内部的`this`是`ubderfined`，因为`babel`编译后开启了严格模式

`render`之后的过程

1. `React`解析组件标签，找到了`MyComponent`组件
2. 返现组件是使用函数定义的，随后调用该函数，将返回的虚拟`DOM`转为真实`DOM`，随后呈现在页面中

**类式组件**

```
<div id="test"></div>
<script type="text/babel">
// 1. 创建类式组件
class MyComponent extends React.Component{
    render() {
        return (
            <h2>我是用类定义的组件</h2>
        )
    }
}

// 2. 渲染组件到页面
ReactDOM.render(<MyComponent />, document.getElementById("test"))
```

`render`是放在了原型对象上，供实例使用

`render()`函数内部的`this`指向`MyComponent`的实例对象

`ReactDOM.render`之后的过程

1. `React`解析组件标签，找到了`MyComponent`组件
2. 发现组件是类定义的，随后创建该类的实例，并通过该实例代用原型上的`render`方法
3. 将`render`返回的虚拟`DOM`转换为真实`DOM`，随后呈现在页面中

**总结**

函数式组件适用于简单组件

类式组件适用于复杂组件

### 2.2 三大核心属性

三大核心属性仅仅针对类式组件

#### 2.2.1 state

**理解**

1. `state`是组件对象最重要的属性，值是对象(可以包含多个`key-value`的组合)
2. 组件被称为''状态机“，通过更新组件的`state`来更新对应的页面显示(重新渲染组件)

**强烈注意**

1. 组件中的`render`方法中的`this`为组件实例对象

2. 组件自定义的方法中`this`为`undefined`

   强制绑定`this`通过函数对象的`bind()`

   箭头函数

3. 状态数据，不能直接修改或更新

