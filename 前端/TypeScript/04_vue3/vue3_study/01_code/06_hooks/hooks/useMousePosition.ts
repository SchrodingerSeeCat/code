import { onBeforeMount, onMounted, ref } from 'vue'

export default function() {
    const x = ref(-1)
    const y = ref(-1)
    
    // 点击事件的回调函数
    const clickHandler = (event: MouseEvent) => {
        x.value = event.pageX
        y.value = event.pageY
    }

    // 页面挂载之后创建点击事件
    onMounted(() => {
        window.addEventListener('click', clickHandler)
    })

    // 页面卸载之前移除点击事件
    onBeforeMount(() => {
        window.removeEventListener('click', clickHandler)
    })

    return {
        x,
        y
    }
}