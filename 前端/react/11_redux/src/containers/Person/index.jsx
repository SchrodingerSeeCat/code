import React, { Component } from 'react'
import { nanoid } from 'nanoid'
import { connect } from 'react-redux'

import { addPerson } from '../../redux/actions/person'

class Person extends Component {

    // 添加一个人
    addPerson = () => {
        const person = {
            id: nanoid(),
            name: this.nameNode.value,
            age: this.ageNode.value * 1
        }
        this.props.addPerson(person)

        // 清空输入框
        this.nameNode.value = ''
        this.ageNode.value = ''
    }

    render() {
        return (
            <div>
                <h2>我是Person组件, 上方组件求和为{this.props.count}</h2>
                <input ref={c => this.nameNode = c} type="text" placeholder="输入名字"/>
                <input ref={c => this.ageNode = c} type="text" placeholder="输入年龄"/>
                <button onClick={this.addPerson}>添加</button>
                <ul>
                    {
                        this.props.persons.map((person) => {
                            return <li key={person.id}>{person.name}</li>
                        })
                    }
                </ul>
            </div>
        )
    }
}

export default connect(
    // 映射状态
    state => ({
        persons: state.persons,
        count: state.count
    }),
    
    // 映射操作的方法
    {
        addPerson: addPerson
    }
)(Person)