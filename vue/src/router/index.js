import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    redirect:"/index/1"
  },{
    path: '/xieriji',
    name: 'xieriji',
    component:()=>import('../views/xieriji.vue')

  },{
    path: '/center',
    name: 'center',
    component:()=>import('../views/center.vue')

  },{
  path: '/diary',
    name: 'diary',
    component: ()=>import('../views/diary.vue')
  },{
  path: '/paid',
    name: 'paid',
    component:()=>import('../views/paid.vue')
  },{
  path: '/pingjia/:oid',
    name: 'pingjia',
    component:()=>import('../views/pingjia.vue')

  },

  {
    path: '/index/:log',
    name: 'Home',
    component: Home
  },{
  path: '/plan',
    name: 'plan',
    component: () => import('../views/plan.vue')
  },
  {
    path:"/evaluate",
    name: 'evaluate',
    component: () => import('../views/evaluate.vue')
  },
  {
    path: '/gallery',
    name: 'gallery',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/gallery.vue')
  },
  {
    path: '/query',
    name: 'query',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/query.vue')
  },
  {
    path: '/login/:role',
    name: 'login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  },
  {
    path: '/manage',
    name: 'manage',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/manage.vue')
  },

  {
    path: '/fitness_list',
    name: 'fitness_list',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/fitness_list.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
