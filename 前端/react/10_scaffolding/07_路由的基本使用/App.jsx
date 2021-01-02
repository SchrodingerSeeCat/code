import React, { Component } from 'react'
import {Link, BrowserRouter, Route} from "react-router-dom"

import About from "./components/About"
import Home from "./components/Home"

export default class App extends Component {

    render() {
        return (
            <div>
                <div className="row">
                    <div className="col-xs-offset-2 col-xs-8">
                        <div className="page-header"><h2>React Router Demo</h2></div>
                    </div>
                </div>
                <BrowserRouter>
                    <div className="row">
                        <div className="col-xs-2 col-xs-offset-2">
                            <div className="list-group">

                                {/* 原生HTML的跳转 */}
                                {/* <a className="list-group-item" href="./about.html">About</a>
                                <a className="list-group-item active" href="./home.html">Home</a> */}

                                {/* react路由链接切换组件 ---编写路由链接 */}
                                <Link className="list-group-item" to="/about">About</Link>
                                <Link className="list-group-item" to="/home">Home</Link>
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
                </BrowserRouter>
            </div>
        )
    }
}
