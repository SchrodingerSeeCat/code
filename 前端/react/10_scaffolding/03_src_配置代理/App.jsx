import React, { Component } from 'react'
import axios from 'axios'

export default class App extends Component {
    getStudentData = () => {
        axios.get('http://localhost:3000/api1/student')
        .then(
            res => {
                console.log(res.data)
            },
            error => {
                console.log(error)
            }
        )
        
    }

    render() {
        return (
            <div>
                <button onClick={this.getStudentData}>点我获取数据</button>
            </div>
        )
    }
}
