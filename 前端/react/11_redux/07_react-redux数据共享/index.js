import React from 'react'
import ReactDOM from 'react-dom'

import App from './App'

import store from './redux/store'

// 使用Provider自动引入store
import { Provider } from 'react-redux'

ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>, 
    document.getElementById('root')
)

