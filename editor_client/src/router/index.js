import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import UserInstance from "../views/UserInstance";
import Instance from "../views/Instance";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/userInstance',
        name: 'UserInstance',
        component: UserInstance
    },
    {
        path: '/instance',
        name: 'Instance',
        component: Instance
    }
]

const router = new VueRouter({
    mode: 'history',
    routes
})

export default router
