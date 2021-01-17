import React, { PureComponent } from 'react'

import './index.css'


export default class Parent extends PureComponent {
    state = {
        carName: '奔驰c36'
    }

    changeCar = () => {
        this.setState({carName: '迈巴赫'})
        // this.setState({carName: '奔驰c36'})
        // this.setState({})
    }

    // shouldComponentUpdate(nextProps, nextState){
    //    return this.state.carName !== nextState.carName
    // }

    render() {
        const {carName} = this.state
        console.log('parent')
        return (
            <div className="parent">
                <h3>我是父组件</h3>
                <br/>
                <span>父组件的车：{carName}</span>
                <br/>
                <button onClick={this.changeCar}>点我换车</button>
                <Child carName={carName}></Child>
            </div>
        )
    }
}

class Child extends PureComponent {

    // shouldComponentUpdate(nextProps, nextState){
    //     return this.props.carName !== nextProps.nextProps
    // }

    render() {
        console.log('child')
        return (
            <div className="child">
                <h3>我是子组件</h3>
                <span>子组件的车：{this.props.carName}</span>
            </div>
        )
    }
}
