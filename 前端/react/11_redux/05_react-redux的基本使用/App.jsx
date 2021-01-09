import React, { Component } from 'react'

// 引入容器组件
import Count from './containers/Count'

// react-redux需要在组件中使用props传递store
import store from './redux/store'

export default class App extends Component {
    render() {
        return (
            <div>
                {/* 给容器组件传递store */}
                <Count store={store}/>
            </div>
        )
    }
}
