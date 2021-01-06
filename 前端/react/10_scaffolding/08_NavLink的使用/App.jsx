import React, { Component } from 'react'
import {Link, NavLink, BrowserRouter, Route} from "react-router-dom"

import About from "./pages/About"
import Home from "./pages/Home"

export default class App extends Component {

    render() {
        return (
            <div>
                <div className="row">
                    <div className="col-xs-offset-2 col-xs-8">
                        <div className="page-header"><h2>React Router Demo</h2></div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-xs-2 col-xs-offset-2">
                        <div className="list-group">

                            {/* 原生HTML的跳转 */}
                            {/* <a className="list-group-item" href="./about.html">About</a>
                            <a className="list-group-item active" href="./home.html">Home</a> */}

                            {/* react路由链接切换组件 ---编写路由链接 */}
                            <NavLink activeClassName="active" className="list-group-item" to="/about">About</NavLink>
                            <NavLink activeClassName="active" className="list-group-item" to="/home">Home</NavLink>
                        </div>
                    </div>
                    <div className="col-xs-6">
                        <div className="panel">
                            <div className="panel-body">
                                {/* 注册路由 */}
                                <Route path="/about" component={About}/>
                                <Route path="/home" component={Home}/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
