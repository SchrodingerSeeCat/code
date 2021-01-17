import React, { Component } from 'react'

import './index.css'

export default class Parent extends Component {
    render() {
        return (
            <div className='parent'>
                <h3>我是Parent</h3>
                <Child render={(name) => <Grand name={name}/>}>
                </Child>
            </div>
        )
    }
}

class Child extends Component {

    state = {
        name: 'tom'
    }

    render() {
        return (
            <div className='child'>
                {
                    this.props.render(this.state.name)
                }
                <h3>我是Child</h3>
            </div>
        )
    }
}

class Grand extends Component {
    render() {
        return (
            <div className='grand'>
                <h3>我是Grand, 从Child接收到的属性{this.props.name}</h3>
            </div>
        )
    }
}