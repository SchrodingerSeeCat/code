import React, { Component } from 'react'

export default class Message extends Component {
    render() {
        return (
            <div>
                <ul>
                    <li>
                        <a href="/message1">message1</a>
                    </li>                    
                    <li>
                        <a href="/message1">message2</a>
                    </li>                    
                    <li>
                        <a href="/message1">message3</a>
                    </li>
                </ul>
            </div>
        )
    }
}
