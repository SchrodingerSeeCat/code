import React, { Component } from 'react'

// 导入需要的组件
import { Button } from 'antd'
import { WechatOutlined } from '@ant-design/icons'

// 导入组件的样式
import 'antd/dist/antd.css'
export default class App extends Component {
    render() {
        return (
            <div>
                // 按钮组件
                <Button type="primary">Primary Button</Button>

                // 图标
                <WechatOutlined />
            </div>
        )
    }
}
