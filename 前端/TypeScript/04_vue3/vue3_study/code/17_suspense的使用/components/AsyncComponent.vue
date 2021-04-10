<template>
    <h2>AsyncComponet子级组件</h2>
    <h3>{{ msg }}</h3>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
    name: "AsyncComponet",
    setup() {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                resolve({
                    msg: 'Hello'
                }, 10000)
            })
        })
    }
})
</script>

<style>

</style>