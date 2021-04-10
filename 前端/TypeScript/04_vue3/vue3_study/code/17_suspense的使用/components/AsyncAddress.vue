<template>
    <h2>
        AsyncAddress组件
    </h2>
    <h3>{{data}}</h3>
</template>

<script>
import { defineComponent } from "vue";
import axios from 'axios'

export default defineComponent({
    name: "AsyncAddress",

    setup() {
        return axios.get('/data/address.json').then(
            res => {
                return {
                    data: res.data
                }
            }
        )
    }
})
</script>

<style>

</style>