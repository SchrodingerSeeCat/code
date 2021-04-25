<template>
    <ul class="img-container">
        <li class="block" v-for="fit in description" :key="fit">
            <div class="picture">
                <img :src="url" alt="图片列表" class="picture-img"/>
            </div>
            <div class="desc">师傅更多</div>
        </li>
    </ul>
</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
    name: "Picture",
    setup(props) {
        console.log(props)
        return {
            description: ['fill', 'contain', 'cover', 'none', 'scale-down', 'contain', 'contain', 'contain', 'contain', 'contain', 'contain', 'contain', 'contain'],
            url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
        }
    }
})
</script>
<style scoped>
.img-container {
    text-align: center;
    margin-top: 20px;
}
.block{
    width: 220px;
    height: 280px;
    padding: 10px;
    margin-left: 12px;
    margin-right: 12px;
    margin-bottom: 15px;
    box-sizing: border-box;
    text-align: center;
    display: inline-block;
    border: 2px rgba(193, 193, 193, .4) solid;
}

.block:hover {
    transform:translateY(-3px) translateX(-3px);
    box-shadow: 10px 10px 5px rgba(226, 226, 226, .8);
    transition: 2s;
}
.img-container:first-child {
    margin-left: 0;
}
.img-container:first-child {
    margin-right: 0;
}
.picture {
    width: 196px;
    height: 150px;
    overflow: hidden;
}

.picture-img {
    width: 196px;
    height: 150px;
}

.desc {
    box-sizing: border-box;
    padding: 10px;
}
</style>