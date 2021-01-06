import React, { Component } from 'react'
// import qs from 'querystring'

const deatilDate = [
    {id: '01', content: "你好，中国"},
    {id: '02', content: "你好，世界"},
    {id: '03', content: "你好，地球"}
]

export default class Detail extends Component {
    render() {

        // 接受params参数
        const {id, title} = this.props.match.params
        // 接受search参数
        // const {id, title} = qs.parse(this.props.location.search.slice(1))

        // 接受state参数
        // const {id, title} = this.props.location.state || {}

        // 查找对应的消息体
        const findResult = deatilDate.find((detail) => {
            return detail.id === id
        }) || {}
        return (
            <ul>
                <li>ID: {id}</li>
                <li>TITLE: {title}</li>
                <li>CONTENT: {findResult.content}</li>
            </ul>
        )
    }
}
