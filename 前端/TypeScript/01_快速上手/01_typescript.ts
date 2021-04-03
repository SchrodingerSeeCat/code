(() => {
    function sayHi(str : string) {
        return "你好" + str
    }

    let text = "王二狗";
    console.log(sayHi(text))
})()

// ts的文件中如果直接书写js语法的代码，那么在html文件中直接引入ts文件，在谷歌的浏览器中是可以直接使用的
// 如果ts的文件中有ts语法的代码，需要把ts文件编译为js文件