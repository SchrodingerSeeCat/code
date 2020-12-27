const proxy = require('http-proxy-middleware')
module.exports = function(app) {
    app.use(
        proxy('/api1', { // 遇见/api1前缀的请求，就会触发该代理配置
            target: 'http://localhost:8080', // 请求转发地址
            changeOrigin: true,  // 控制服务器收到的请求头中Host字段的值
            pathRewrite: {'^/api1': ''} // 重写请求路径 将/api1替换为空字符
        }),
        proxy('/api2', {
            target: 'http://localhost:8081',
            changeOrigin: true,
            pathRewrite: {'^/api2': ''}
        })
    )
}