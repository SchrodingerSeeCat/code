import React, { Component } from 'react'
import {Route, Switch} from "react-router-dom"

import About from "./pages/About"
import Home from "./pages/Home"
import MyNavLink from "./components/MyNavLink"

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

                            {/* 自己封装NavLink */}
                            <MyNavLink to="/home/test">Home</MyNavLink>
                            <MyNavLink to="/about">About</MyNavLink>
                        </div>
                    </div>
                    <div className="col-xs-6">
                        <div className="panel">
                            <div className="panel-body">
                                <Switch>
                                    {/* 注册路由 */}
                                    <Route path="/about" component={About}/>

                                    {/* 开启精准匹配 */}
                                    <Route exact={true} path="/home" component={Home}/>
                                </Switch>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
