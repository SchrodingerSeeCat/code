import React, { Component } from 'react'

import Count from './containers/Count'
// react-redux需要在组件中使用props传递store
import store from './redux/store'
export default class App extends Component {
    render() {
        return (
            <div>
                <Count store={store}/>
            </div>
        )
    }
}
