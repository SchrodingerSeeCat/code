import React, { Component } from 'react'

import Header from "./components/Header"
import List from "./components/List"
import Footer from "./components/Footer"

import "./App.css"

export default class App extends Component {

    // 操作状态的方法在哪里，状态就在哪里
    // 初始化状态
    state = {
        todos: [
            {id: '001', name: '吃饭', done: true},
            {id: '002', name: '睡觉', done: false},
            {id: '003', name: '写代码', done: true},
            {id: '004', name: '逛街', done: true}
        ]
    }

    // 添加一个todo
    addTodo = (todoObj) => {
        // 追加一个新的todo
        const newTodos = [todoObj, ...this.state.todos]

        // 更新状态
        this.setState({
            todos: [...newTodos]
        })
    }

    // 修改item的状态 
    updateTodo = (id, done) => {
        // 获取状态中的todos
        const {todos} = this.state

        // 修改制定id的done
        const newTodos = todos.map((todoObj) => {
            if(todoObj.id === id) {
                return {...todoObj, done: done}
            }
            return todoObj
        })

        this.setState({todos: newTodos})
    }

    // 删除一个todo
    deleteTodo = (id) => {
        // 获取状态中的todos
        const {todos} = this.state

        // 修改制定id的done
        const newTodos = todos.filter((todoObj) => {
            return todoObj.id !== id
        })

        this.setState({todos: newTodos})
    }

    // 全选
    checkAllTodo = (done) => {
        // 获取原来的todos
        const {todos} = this.state

        // 加工数据
        const newTodos = todos.map((todo) => {
            return {...todo, done: done}
        })

        // 更新状态
        this.setState({todos: newTodos})
    }

    // 清除所有已经完成的todo
    clearAllDone= () => {
        const {todos} = this.state

        const newTodos = todos.filter((todo) => {
            return !todo.done
        })

        this.setState({todos: newTodos})
    }
    render() {
        return (
            <div className="todo-container">
                <div className="todo-wrap">
                    <Header addTodo={this.addTodo} />
                    <List todos={this.state.todos} updateTodo={this.updateTodo} deleteTodo={this.deleteTodo}/>
                    <Footer todos={this.state.todos} checkAllTodo={this.checkAllTodo} clearAllDone={this.clearAllDone}/>
                </div>
            </div>
        )
    }
}
