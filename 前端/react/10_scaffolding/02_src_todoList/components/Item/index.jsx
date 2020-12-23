import React, { Component } from 'react'
import PropTypes from 'prop-types'

import './index.css'

export default class Item extends Component {

    // 对接受的props进行：类型、必要性限制
    static propTypes = {
        id: PropTypes.string.isRequired,
        name: PropTypes.string.isRequired,
        done: PropTypes.bool.isRequired,
        updateTodo: PropTypes.func.isRequired,
        deleteTodo: PropTypes.func.isRequired
    }

    state = {
        // 用于标识鼠标是否在当前的item上
        mouse: false
    }

    render() {
        const {id, name, done} = this.props
        return (
            <li style={{backgroundColor: this.state.mouse ? '#ddd' : 'white'}} onMouseEnter={this.handleMouse(true)} onMouseLeave={this.handleMouse(false)}>
                <label>
                    <input type="checkbox" checked={done} onChange={this.handleCheck(id)}/>
                    <span>{name}</span>
                </label>
                <button onClick={() => {this.handleDelete(id)}} className="btn btn-danger" style={{ display: this.state.mouse ? 'block' : 'none' }}>删除</button>
            </li>
        )
    }

    // 处理鼠标移入移出
    handleMouse = (flag) => {
        return () => {
            this.setState({mouse: flag})
        }
    }

    // 勾选、取消勾选
    handleCheck = (id) => {
        return (event) => {

            this.props.updateTodo(id, event.target.checked)
        }
    }

    // 删除一个todo
    handleDelete = (id) => {
        if(window.confirm('确定删除吗？')) this.props.deleteTodo(id)
    }
}
