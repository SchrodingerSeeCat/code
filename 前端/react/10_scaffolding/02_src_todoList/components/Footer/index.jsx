import React, { Component } from 'react'

import './index.css'

export default class Footer extends Component {

    // 全选
    handleCheckAll = (event) => {
        this.props.checkAllTodo(event.target.checked)
    }

    // 清除已经完成的所有任务
    handleDeleteAll = () => {
        this.props.clearAllDone()
    }

    render() {
        const {todos} = this.props

        // 计算已完成的个数
        const count = todos.reduce((pre, current) => {
            return pre + (current.done ? 1 : 0) 
        }, 0)

        
        // 总数
        const total = todos.length
        return (
            <div className="todo-footer">
                <label>
                <input type="checkbox" checked={count === total && total !== 0} onChange={this.handleCheckAll}/>
                </label>
                <span>
                <span>已完成{count}</span> / 全部{total}
                </span>
                <button className="btn btn-danger" onClick={this.handleDeleteAll}>清除已完成任务</button>
            </div>
        )
    }
}
