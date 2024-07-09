import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/login/UserView.vue'
import AdminView from "@/views/login/AdminView.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/login/AdminView.vue')
  },

  {
    path: '/admin',
    name: 'admin',
    component: () => import('../views/login/AdminView.vue')
  },
  {
    path: '/user',
    name: 'user',
    component: () => import('../views/login/UserView.vue')
  },
  {
    path: '/checkAdmin',
    name: 'checkAdmin1',
    component: () => import('../views/Mange/CheckAdmin.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router