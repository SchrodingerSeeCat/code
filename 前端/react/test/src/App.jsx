import React, { Component } from 'react'
import axios from 'axios'

export default class App extends Component {

    state = {
        msg: ''
    }

    componentDidMount() {
        axios.get('/config.json')
        .then(
            res => {
                this.setState({msg: res.data.test})
            },
            err => {
                console.log(err)
            }
        )
    }

    render() {
        return (
            <div>
                <div>
                    {this.state.msg}
                </div>
            </div>
        )
    }
}
