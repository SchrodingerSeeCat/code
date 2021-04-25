import {createRouter, createWebHashHistory} from "vue-router";

import Home from '../components/Home.vue'
import Admin from '../components/admin/Admin.vue'
import Picture from '../components/user/picture/Picture.vue'

const routes = [
    {
        path: '/home',
        component: Home,
        children: [
            {
                path: 'recommend',
                name: 'recommend',
                component: Picture
            },
            {
                path: 'comic',
                name: 'comic',
                component: Picture
            },
            {
                path: 'scenery',
                name: 'scenery',
                component: Picture
            },
            {
                path: 'life',
                name: 'life',
                component: Picture
            },
        ]
    },
    {
        path: '/',
        redirect: '/home'
    },
    {
        path: '/admin',
        component: Admin
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
})

export default router