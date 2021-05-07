const fs = require("fs")
const utils = require("util")
const mineReadFile = utils.promisify(fs.readFile)


const main = async() => {
    // 读取第一个文件的内容
    try {
        let data1 = await mineReadFile("./01-async.html")
        let data2 = await mineReadFile("./02-await.html")
        console.log(data1.toString(), data2.toString())
    } catch(err) {
        console.log(err)
    }
}

main()