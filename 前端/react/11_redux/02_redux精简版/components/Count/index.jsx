import React, { Component } from 'react'

// 引入store
import store from '../../redux/store'

export default class Count extends Component {

    // 检测redux的状态改变的方法，一般写在index.js中
    // componentDidMount() {
    //     // 检测redux中状态的变化，只要变化，就调用render
    //     store.subscribe(() => {
    //         // 用户不能调用render，采用设置状态的方法被动调用render
    //         this.setState({})
    //     })
    // }

    // 加操作
    increment = () => {
        const {value} = this.selectNumber
        store.dispatch({type: 'increment', data: value * 1})
    }

    // 减操作
    decrement = () => {
        const {value} = this.selectNumber
        store.dispatch({type: 'decrement', data: value * 1})
    }

    // 奇数加
    incrementIfOdd = () => {
        const count = store.getState()
        if(count % 2 !== 0) {
            const {value} = this.selectNumber
            store.dispatch({type: 'increment', data: value * 1})
        }
    }

    // 异步加
    incrementAsync = () => {
        const {value} = this.selectNumber
        setTimeout(() => {
            store.dispatch({type: 'increment', data: value * 1})
        }, 2000)
    }
    render() {
        return (
            <div>
                <h1>当前求和为：{store.getState()}</h1>
                <select ref={c => this.selectNumber = c}>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>&nbsp;
                <button onClick={this.increment}>+</button>&nbsp;
                <button onClick={this.decrement}>-</button>&nbsp;
                <button onClick={this.incrementIfOdd}>当前和为奇数再+</button>&nbsp;
                <button onClick={this.incrementAsync}>异步+</button>
            </div>
        )
    }
}
