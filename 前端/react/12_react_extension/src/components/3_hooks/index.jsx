import React, { Component } from 'react'
import ReactDOM from 'react-dom'

// 类式组件
// export default class Demo extends Component {

//     state = {count: 0}
    
//     add = () => {
//         this.setState((state) => {
//             return {count: state.count + 1}
//         })
//     }

//     render() {
//         return (
//             <div>
//                 <h2>当前求和为：{this.state.count}</h2>
//                 <button onClick={this.add}>点我加1</button>
//             </div>
//         )
//     }
// }

export default function() {
    // useState 使用state
    // 返回一个数组，a[0]表示状态， a[1]表示更新状态的方法
    const [count, setCount] = React.useState(0)

    // 加1
    function add() {
        // 第一种写法
        // setCount(count + 1)

        // 第二种写法
        setCount(count => count + 1)
    }

    // 卸载组件
    function unmount() {
        ReactDOM.unmountComponentAtNode(document.getElementById('root'))
    }

    // useEffect 使用生命周期钩子, 第二个参数指定检测哪些值的变化，不写检测所有
    // 空数组相当于组件挂载之前的钩子 返回的函数相当于组件卸载之前的钩子
    React.useEffect(() => {
        const timer = setInterval(() => {
            setCount(count => count+1)
        }, 1000)
        return () => {
            clearInterval(timer)
        }
    }, [])


    // useRef 返回一个ref容器，存储数据
    const myRef = React.useRef()
    function show () {
        console.log(myRef.current.value)
    }
    return (
        <div>
            <input type="text" ref={myRef}/>
            <h2>当前求和为：{count}</h2>
            <button onClick={add}>点我加1</button>
            <button onClick={unmount}>卸载组件</button>
            <button onClick={show}>点击提示数据</button>
        </div>
    )
}

