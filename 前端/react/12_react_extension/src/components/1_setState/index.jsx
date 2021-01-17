import React, { Component } from 'react'

export default class Demo extends Component {

    state = {
        count: 0
    }


    add = () => {
        // 对象式setState
        // // 1. 获取原来的值
        // const {count} = this.state
        // // 2. 更新状态
        // this.setState({count: count + 1}, () => {
        //     // 这个回调会在状态更新之后被调用
        //     console.log(this.state.count)
        // })
        // // react更新状态是一个异步的过程，此时拿到的count只能是未被更改之前的count
        // // console.log(this.state.count)


        // 函数式的setState
        this.setState((state, props) => {
            return {count: state.count + 1}
        })
    }

    render() {
        return (
            <div>
                <h1>当前求和为：{this.state.count}</h1>
                <button onClick = {this.add}>点我加1</button>
            </div>
        )
    }
}
