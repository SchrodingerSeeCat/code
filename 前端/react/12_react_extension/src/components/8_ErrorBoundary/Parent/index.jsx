import React, { Component } from 'react'
import Child from './Child'

export default class Parent extends Component {

    state = {
        hasError: null // 用于标识子组件是否出现错误
    }

    // 处理边界错误
    // 如果此组件的所有子组件出现错误，都会调用此方法, 并携带错误信息
    static getDerivedStateFromError(error){
        console.log(error)
        return {
            hasError: error
        }
    }

    // 当页面渲染出错时，会调用此方法
    // 一般用于统计错误此处，反馈给服务器，用于通知编码人员进行bug的解决
    componentDidCatch() {
        console.log('渲染组件出错')
    }
    render() {
        return (
            <div>
                <h3>我是父组件</h3>
                {this.state.hasError ? <h2>当前网络不稳定，请稍后再试</h2> : <Child />}
                <Child />
            </div>
        )
    }
}
