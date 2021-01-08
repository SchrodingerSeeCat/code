import React, { Component } from 'react'

export default class Count extends Component {

    state = {
        count: 0
    }

    // 加操作
    increment = () => {
        const {value} = this.selectNumber
        const {count} = this.state
        this.setState({count: count + value * 1})
    }

    // 减操作
    decrement = () => {
        const {value} = this.selectNumber
        const {count} = this.state
        this.setState({count: count - value * 1})
    }

    // 奇数加
    incrementIfOdd = () => {
        const {count} = this.state
        if(count % 2 !== 0) {
            const {value} = this.selectNumber
            this.setState({count: count + value * 1})
        }
    }

    // 异步加
    incrementAsync = () => {
        const {value} = this.selectNumber
        const {count} = this.state
        setTimeout(() => {
            this.setState({count: count + value * 1})
        }, 2000)
    }
    render() {
        return (
            <div>
                <h1>当前求和为：{this.state.count}</h1>
                <select ref={c => this.selectNumber = c}>
                    <option value="1">1</option>
                    <option value="1">2</option>
                    <option value="1">3</option>
                </select>&nbsp;
                <button onClick={this.increment}>+</button>&nbsp;
                <button onClick={this.decrement}>-</button>&nbsp;
                <button onClick={this.incrementIfOdd}>当前和为奇数再+</button>&nbsp;
                <button onClick={this.incrementAsync}>异步+</button>
            </div>
        )
    }
}
