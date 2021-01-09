import React, { Component } from 'react'
import { nanoid } from 'nanoid'

export default class Person extends Component {

    addPerson = () => {
        const person = {
            id: nanoid(),
            name: this.nameNode.value,
            age: this.ageNode.value * 1
        }
        console.log(person)
    }

    render() {
        return (
            <div>
                <h2>我是Person组件</h2>
                <input ref={c => this.nameNode = c} type="text" placeholder="输入名字"/>
                <input ref={c => this.ageNode = c} type="text" placeholder="输入年龄"/>
                <button onClick={this.addPerson}>添加</button>
                <ul>
                    <li>名字： 年龄：</li>
                    <li>名字： 年龄：</li>
                    <li>名字： 年龄：</li>
                </ul>
            </div>
        )
    }
}
