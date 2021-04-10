// 引入axios
import axios from 'axios'
import { ref } from 'vue'

// 发送ajax的请求
export default function<T> (url: string) {

    // 现在状态
    const loading = ref(true)
    // 请求成功的数据
    const data = ref<T | null>(null)
    // 错误信息
    const error = ref("")

    axios.get(url).then(
        res => {
            // 改变加载状态
            loading.value = false
            data.value = res.data
        }
    ).catch(
        err => {
            // 改变加载状态
            loading.value = false
            error.value = err.message || '未知的错误'
        }
    )
    return {
        loading,
        data,
        error
    }
}