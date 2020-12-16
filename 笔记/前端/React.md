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

#### 1.2.1 基本语法

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

