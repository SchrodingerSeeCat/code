import React, { Component, lazy, Suspense } from 'react'
import {NavLink, Route, Switch} from "react-router-dom"

// import About from "./About"
// import Home from "./Home"
const Home = lazy(() => import ('./Home'))
const About = lazy(() => import ('./About'))

export default class Demo extends Component {

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
                            <NavLink className="list-group-item" to="/about">About</NavLink>
                            <NavLink className="list-group-item" to="/home">Home</NavLink>
                        </div>
                    </div>
                    <div className="col-xs-6">
                        <div className="panel">
                            <div className="panel-body">
                                <Suspense fallback={<h1>Loading....</h1>}>
                                    <Switch>
                                        {/* 注册路由 */}
                                        <Route path="/about" component={About}/>
                                        <Route path="/home" component={Home}/>
                                    </Switch>
                                </Suspense>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
