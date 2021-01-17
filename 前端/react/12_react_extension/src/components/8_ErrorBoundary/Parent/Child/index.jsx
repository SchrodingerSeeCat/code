import React, { Component } from 'react'

export default class Child extends Component {
    state = {
        // persons: [
        //     {id: '001', name: 'jack', age: 12},
        //     {id: '002', name: 'tom', age: 15},
        //     {id: '003', name: 'jerry', age: 18}
        // ]

        persons: 'abc'
    }
    render() {
        return (
            <div>
                <h4>我是子组件</h4>
                {
                    this.state.persons.map(item => {
                        return <li key={item.id}>{item.name}----{item.age}</li>
                    })
                }
            </div>
        )
    }
}
