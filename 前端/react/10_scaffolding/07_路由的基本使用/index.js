// 引入React核心库
import React from 'react'
// 引入ReactDOM
import ReactDOM from 'react-dom'
// 引入
import {BrowserRouter} from 'react-router-dom'

import App from './App'

ReactDOM.render(
    <BrowserRouter>
        <App />
    </BrowserRouter>
, document.getElementById('root'))