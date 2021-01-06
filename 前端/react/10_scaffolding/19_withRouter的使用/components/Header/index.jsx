import React, { Component } from 'react'
import {withRouter} from 'react-router-dom'

class Header extends Component {
    // 回退
    back = () => {
        this.props.history.goBack()
    }

    // 前进
    forward = () => {
        this.props.history.goForward()
    }

    // 回退两步
    go =() => {
        this.props.history.go(-2)
    }

    render() {
        return (
            <div className="page-header">
                <button onClick={this.back}>回退</button>
                <button onClick={this.forward}>前进</button>
                <button onClick={this.go}>go</button>
                <h2>React Router Demo</h2>
            </div>
        )
    }
}

// withRouter将一般组件加工成路由组件
export default withRouter(Header)
