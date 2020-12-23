import React, { Component } from 'react'
import {nanoid} from 'nanoid'
import PropTypes from 'prop-types'

import './index.css'

export default class Header extends Component {

    // 对接受的props进行：类型、必要性限制
    static propTypes = {
        addTodo: PropTypes.func.isRequired
    }


    render() {
        return (
            <div className="todo-header">
                <input onKeyUp={this.handleKeyUp} type="text" placeholder="请输入你的任务名称，按回车键确认"/>
            </div>
        )
    }

    // 添加todo
    handleKeyUp = (event) => {
        // 判断是否为回车
        if(event.keyCode !== 13) return
        // 添加的todo的名字不能为空
        if(event.target.value.trim() === '') {
            alert("输入不能为空")
            event.target.value = ""
            return
        }

        // 创建新添加的todo
        const newTodo = {id: nanoid(),name: event.target.value.trim(), done: false}

        // 通知App添加新的todo
        this.props.addTodo(newTodo)

        // 清空输入框
        event.target.value = ""
    }
}
