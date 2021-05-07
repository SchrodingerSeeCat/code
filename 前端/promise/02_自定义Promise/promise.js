// 构造函数
// "use strict"
function Promise (executor) {
    // 添加属性和状态
    this.promiseState = "pending"
    this.promiseResult = null
    this.callabcks = []

    // resolve函数
    const resolve = (data) => {
        if (this.promiseState !== "pending") return
        // 修改对象的状态(promiseState)
        this.promiseState = "fulfilled"
        // 设置对象结果值(promiseResult)
        this.promiseResult = data

        this.callabcks.forEach((callabck) => {
            if (callabck.onResolved){
                callabck.onResolved(data)
            }
        })
    }

    // reject函数
    const reject = (error) => {
        if (this.promiseState !== "pending") return
        // 修改对象的状态(promiseState)
        this.promiseState = "rejected"
        // 设置对象结果值(promiseResult)
        this.promiseResult = error

        this.callabcks.forEach((callabck) => {
            if (callabck.onReject){
                callabck.onReject(error)
            }
        })
    }
    try{
        // 同步调用 执行器函数
        executor(resolve, reject)
    } catch(error) {
        reject(error)
    }
}

// 添加then方法
Promise.prototype.then = function(onResolved, onReject) {
    return new Promise((resolve, reject)=> {
        // 封装回调函数
        const callback = (type) => {
            try{
                // 执行成功的回调
                let result = type(this.promiseResult)
                if (result instanceof Promise) { // 是promise类型，执行promise操作
                    result.then(value => {
                        resolve(value)
                    }, reason => {
                        reject(reason)
                    })
                } else { // 否则直接resolve
                    resolve(result)
                }
            } catch(err) {
                reject(err)
            }
        }
        if (this.promiseState === "fulfilled") {
            callback(onResolved)
        } else if (this.promiseState === "rejected"){
            callback(onReject)
        } else { // 异步任务处理
            // 保存回调函数
            this.callabcks.push({
                onResolved: () => {
                    callback(onResolved)
                },
                onReject: () => {
                    callback(onReject)
                }
            })
        }
    })
}

// catch方法
Promise.prototype.then = function(onReject){
    return this.then(undefined, onReject)
}