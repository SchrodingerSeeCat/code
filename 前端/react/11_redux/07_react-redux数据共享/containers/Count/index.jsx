import React, { Component } from 'react'

// 引入connect用于连接UI组件与redux
import {connect} from 'react-redux'

// 引入action
import { 
    createIncrementAction, 
    createIncrementAsyncAction, 
    createDecrementAction 
} from "../../redux/actions/count"

// 定义UI组件
class Count extends Component {

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
                <h2>我是Count组件, 下方组件总人数为{this.props.personCount}</h2>
                <h4>当前求和为：{this.props.count}</h4>
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

// 创建并暴露一个容器组件
export default connect(
    state => (
        {count: state.count, personCount: state.persons.length}
    ),

    // mapDispatchToProps的简写，传送action，react-redux自动dispatch
    {
        increment: createIncrementAction,
        decrement: createDecrementAction,
        incrementAsync: createIncrementAsyncAction
    }
)(Count)
