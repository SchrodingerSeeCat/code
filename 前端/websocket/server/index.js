// 需要安装ws nodemon库
const Ws = require('ws');

((Ws) => {
    const server = new Ws.Server({port: 8000})

    const init = () => {
        bindEvent()
    }

    function bindEvent() {
        server.on('open', handleOpen)
        server.on('close', handleClose)
        server.on('error', handleError)
        server.on('connection', handleConnection)
    }


    function handleOpen() {
        // 连接打开
        console.log('server websocket open')
    }

    function handleClose() {
        // 连接关闭
        console.log('server websocket close')
    }
    function handleError() {
        // 连接出错
        console.log('server websocket error')
    }
    function handleConnection(ws) {
        console.log('server websocket connection')
        // 建立连接
        ws.on('message', handleMessage)
        
    }

    // 接受前端发送的消息
    function handleMessage(msg) {
        console.log(msg)

        // 广播消息
        server.clients.forEach((c) => {
            c.send(msg)
        })
    }

    init()
})(Ws)