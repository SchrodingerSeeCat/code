import React from 'react'
import ReactDOM from 'react-dom'

import App from './App'

import store from './redux/store'

// 使用Provider自动引入store
import { Provider } from 'react-redux'

ReactDOM.render(
    // 使用Provider包裹App，目的是让App所有的后代容器组件都能接受到store
    <Provider store={store}>
        <App />
    </Provider>, 
    document.getElementById('root')
)

