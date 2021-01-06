import React, { Component } from 'react'
import {Link, Switch, Route} from 'react-router-dom'

import Detail from './Detail'

export default class Message extends Component {
    state = {
        messageArr: [
            {id: '01', title: '消息1'},
            {id: '02', title: '消息2'},
            {id: '03', title: '消息3'}
        ]
    }

    render() {
        return (
            <div>
                <ul>
                    {
                        this.state.messageArr.map((msg) => {
                            return <li key={msg.id}>
                                    {/* 向路由组件传递params参数 */}
                                        <Link to={`/home/message/detail/${msg.id}/${msg.title}`} href="xxx">{msg.title}</Link>&nbsp;&nbsp;
                                    </li>
                        })
                    }
                </ul>
                <hr/>
                <Switch>
                    <Route path="/home/message/detail/:id/:title" component={Detail} />
                </Switch>
            </div>
        )
    }
}
