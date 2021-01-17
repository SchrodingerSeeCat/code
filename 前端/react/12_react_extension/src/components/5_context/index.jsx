import React, { Component, Fragment } from 'react'

// 1. 创建context对象
const MyContext = React.createContext()
export default class A extends Component {
    state = {
        username: 'tom'
    }
    render() {
        return (
            <Fragment>
                <h3>我是A组件</h3>
                <h4>我的用户名是：{this.state.username}</h4>
                <MyContext.Provider value={this.state.username}>
                    <B />
                </MyContext.Provider>
            </Fragment>
        )
    }
}
class B extends Component {
    render() {
        return (
            <Fragment>
                <h3>我是B组件</h3>
                <C />
            </Fragment>
        )
    }
}

class C extends Component {
    // 声明context属性
    static contextType = MyContext

    render() {
        return (
            <Fragment>
                <h3>我是C组件</h3>
                <h4>我从A组件接受到的用户名是：{this.context}</h4>
                <D />
            </Fragment>
        )
    }
}

// 函数式组件的用法
function D() {
    return (
        <Fragment>
            
            <MyContext.Consumer>
                {
                    value => <h3>我是D组件, {value}</h3>
                }
            </MyContext.Consumer>
        </Fragment>
    )
}