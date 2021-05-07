// 封装Promise读取文件内容
const mineReadFile = (path) => {
    return new Promise((resolve, reject) => {
        require('fs').readFile(path, (err, data) => {
            if (err) {
                reject(err)
            }
            resolve(data)
        })
    })
}


mineReadFile("./01-初体验.html")
.then(
    data => {
        console.log(data.toString())
    },
    err => {
        console.log(err)
    }
)