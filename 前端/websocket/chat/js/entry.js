((doc, storage, location) => {

    // 需要安装vite
    const oUsername = doc.querySelector("#username")
    const oEnter = doc.querySelector("#enter")

    // 程序的初始化
    const init = () => {
        bindEvent()
    }

    function bindEvent() {
        oEnter.addEventListener('click', handleEnteryBtnClick, false)

    }

    function handleEnteryBtnClick() {
        const username = oUsername.value.trim()

        if(username.length < 6) {
            alert('用户名不小于6位')
            return
        }

        // 将用户名存储起来
        storage.setItem('username', username)

        location.href = 'index.html'
        
    }

    init()
})(document, localStorage, location)