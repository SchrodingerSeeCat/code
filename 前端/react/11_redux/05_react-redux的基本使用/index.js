import React from 'react'
import ReactDOM from 'react-dom'

import store from './redux/store'
import App from './App'

ReactDOM.render(<App />, document.getElementById('root'))

// 检测redux中状态的改变，如redux的状态发生了改变，那么重新渲染App组件
store.subscribe(() => {
    // 由于虚拟DOM的性质，状态发生改变的组件，才会重新调用render渲染
    ReactDOM.render(<App />, document.getElementById('root'))
})
