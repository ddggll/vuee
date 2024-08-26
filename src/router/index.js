import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '../views/login/login.vue'
import layout from '../views/layout/layout.vue'
import Cookies from "js-cookie"


Vue.use(VueRouter)


//=====管理页=======
const routes = [
  {
    path: '/',
    name: 'login',
    component: login,
    redirect: 'admin',
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
        component: () => import('@/views/superAdminMange/CheckAdmin.vue')
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
      },
      {
        path: '/siteMange',
        name: 'siteMange',
        component: () => import('@/views/mange/siteMange.vue')
      },
        {
          path: '/test',
          name: 'test',
          component: () => import('@/views/layout/test.vue')
        },

    ]
  },
  {
    path: '*',
    component: () => import('@/views/404.vue')
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('@/viewsUse/bookingPlaceSpan.vue')
  },
  {
    path:'/home',
    name:'home',
    component: () => import('@/viewsUse/home.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


router.beforeEach((to, from, next) => {
  if (to.path === '/admin') return next()
  const admin = Cookies.get("admin")
  if (!admin && to.path !== '/admin') return next('/')  //强制退回登录
  next()
})


export default router