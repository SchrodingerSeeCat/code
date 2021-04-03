(() => {
    // 通过接口的方式作为函数的类型来使用

    interface isSearchFunc{
        (source: string, subString: string) : boolean
    }

    const searchString: isSearchFunc = function(source: string, subString: string) : boolean {
        return source.search(subString) > -1
    }

    console.log(searchString('hahha', 'h'))
})()