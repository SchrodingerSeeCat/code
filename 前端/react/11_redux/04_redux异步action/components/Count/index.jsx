import React, { Component } from 'react'

// 引入store
import store from '../../redux/store'

// 引入action
import { createIncrementAction, createDecrementAction, createIncrementAsyncAction } from '../../redux/count_action'

export default class Count extends Component {

    // 加操作
    increment = () => {
        const {value} = this.selectNumber
        store.dispatch(createIncrementAction(value * 1))
    }

    // 减操作
    decrement = () => {
        const {value} = this.selectNumber
        store.dispatch(createDecrementAction(value * 1))
    }

    // 奇数加
    incrementIfOdd = () => {
        const count = store.getState()
        if(count % 2 !== 0) {
            const {value} = this.selectNumber
            store.dispatch(createIncrementAction(value * 1))
        }
    }

    // 异步加
    incrementAsync = () => {
        const {value} = this.selectNumber
        store.dispatch(createIncrementAsyncAction(value * 1, 500))
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
