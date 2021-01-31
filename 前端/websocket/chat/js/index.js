((doc, Socket, storage, location) => {

    const oList = doc.querySelector("#list")
    const oMsg = doc.querySelector("#message")
    const oSendBtn = doc.querySelector("#send")

    // 用户名
    let username = ''

    // 创建一个websocket对象
    const ws = new Socket("ws:localhost:8000")

    // 绑定事件
    const init = () => {
        bindEvent()
    }

    function bindEvent() {
        oSendBtn.addEventListener('click', handleSendBtnClick, false)

        // 给ws绑定事件处理函数
        ws.addEventListener('open', handleOpen, false)
        ws.addEventListener('close', handleClose, false)
        ws.addEventListener('error', handleError, false)
        ws.addEventListener('message', handleMessage, false)


    }

    function handleSendBtnClick() {
        // 点击发送消息
        const msg = oMsg.value;
        console.log(msg)
        if(msg.trim().length == 0) {
            return
        }

        // 一定要转成字符串
        ws.send(JSON.stringify({
            user: username,
            dateTime: new Date().getTime(),
            msg: msg
        }))

    }

    function handleOpen(event) {

        console.log("websocket open", event)

        // 获取用户名
        username = storage.getItem('username')
        if(!username) {
            location.href = 'entry.html'
            return
        }
    }

    function handleClose(event) {
        // 关闭websocket连接
        console.log("websocket close", event)
    }

    function handleError(event) {
        // websocket连接出错
        console.log("websocket open", error)
    }

    function handleMessage(event) {
        // 处理websocket消息
        console.log("websocket message", event.data)
    }

    init()
})(document, WebSocket, localStorage, location)