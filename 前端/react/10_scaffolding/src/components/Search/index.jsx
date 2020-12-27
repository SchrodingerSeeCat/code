import React, { Component } from 'react'
import axios from 'axios'
import PubSub from 'pubsub-js'

export default class Search extends Component {

    search = () => {
        // 获取用户输入
        const {value} = this.keyWorldElement

        // 发送请求前通知List更新状态，发布消息
        PubSub.publish('atguigu', {
            isFirst: false,
            isLoading: true
        })

        // 发送网络请求
        axios.get(`http://localhost:3000/api/search/users?q=${value}`)
        .then(
            res => {
                 // 请求成功后前通知List更新状态
                 PubSub.publish('atguigu', {
                    isLoading: false,
                    users: res.data.items
                })
            },
            error => {
                 // 请求失败后前通知List更新状态
                 PubSub.publish('atguigu',{
                    isLoading: false,
                    err: error.message // state里面不能直接存储对象
                })
            }
        )
    }

    render() {
        return (
            <section className="jumbotron">
                <h3 className="jumbotron-heading">搜索github用户</h3>
                <div>
                    <input ref={c => this.keyWorldElement = c} type="text" placeholder="输入关键词"/>&nbsp;<button onClick={this.search}>搜索</button>
                </div>
            </section>
        )
    }
}
