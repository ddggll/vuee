import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '../views/login/login.vue'
import layout from '../views/layout/layout.vue'


Vue.use(VueRouter)


//=====管理页=======
const routes = [
  {
    path: '/',
    name: 'login',
    component: login,
    redirect: 'user',
    children: [
      {
        path: 'user',
        name: 'user',
        component: () => import('../views/login/UserLogin.vue')
      },
      {
        path: 'admin',
        name: 'admin',
        component: () => import('../views/login/AdminLogin.vue')
      }
    ]
  },
  {
    path:'/layout',
    name:'layout',
    component: layout,
    redirect:'/application',
    children:[
      {
        path: '/checkAdmin',
        name: 'checkAdmin1',
        component: () => import('@/views/superMange/CheckAdmin.vue')
      },
      {
        path: '/application',
        name: 'application',
        component: () => import('@/views/mange/application.vue')
      },
      {
        path: '/messagesPush',
        name: 'messagesPush',
        component: () => import('@/views/mange/messagesPush.vue')
      }

    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router