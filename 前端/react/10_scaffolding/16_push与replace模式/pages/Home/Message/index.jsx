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
                                        {/* <Link to={`/home/message/detail/${msg.id}/${msg.title}`}>{msg.title}</Link>&nbsp;&nbsp; */}

                                        {/* 向路由组件传递search参数 */}
                                        {/* <Link to={`/home/message/detail/?id=${msg.id}&title=${msg.title}`}>{msg.title}</Link>&nbsp;&nbsp; */}

                                        {/* 向路由组件传递state参数 */}
                                        {/* replace从push模式切换到replace模式 */}
                                        <Link replace={true} to={{pathname: '/home/message/detail', state: {id: msg.id, title: msg.title}}}>{msg.title}</Link>&nbsp;&nbsp;

                                    </li>
                        })
                    }
                </ul>
                <hr/>
                <Switch>
                    {/* 声明接受params参数 */}
                    {/* <Route path="/home/message/detail/:id/:title" component={Detail} /> */}

                    {/* search参数无需声明接受 */}
                    {/* <Route path="/home/message/detail" component={Detail} /> */}

                    {/* state参数无需声明接受 */}
                    <Route path="/home/message/detail" component={Detail} />
                </Switch>
            </div>
        )
    }
}
