import React, { Component } from 'react'

export default class Count extends Component {

    // 加操作
    increment = () => {
        const {value} = this.selectNumber
        this.props.increment(value * 1)
    }

    // 减操作
    decrement = () => {
        const {value} = this.selectNumber
        this.props.decrement(value * 1)
    }

    // 奇数加
    incrementIfOdd = () => {
        if(this.props.count % 2 !== 0) {
            const {value} = this.selectNumber
            this.props.increment(value * 1)
        }
    }

    // 异步加
    incrementAsync = () => {
        const {value} = this.selectNumber
        this.props.incrementAsync(value * 1, 1000)
    }
    render() {
        return (
            <div>
                <h1>当前求和为：{this.props.count}</h1>
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
