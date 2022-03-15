import Vue from 'vue'
import VueRouter from 'vue-router'
// 导入刚才编写的组件
import AppIndex from '@/components/Appindex'
import Login from '@/components/Login'
import Home from '@/components/Home'
import Home2 from '@/components/Home2'
import Admin from '@/components/Admin'
import ToyIndex from '@/components/toy/ToyIndex'
import MineIndex from '@/components/mine/MineIndex'
import MineIndex2 from '@/components/mine/MineIndex2'
import Mes from '@/components/mine/Mes'
import MyPost from '@/components/mine/MyPost'
import MyOrder from '@/components/mine/MyOrder'
import MySell from '@/components/mine/MySell'
import ManageIndex from '@/components/manage/ManageIndex.vue'
import Manage from '@/components/manage/Manage.vue'
import ToyMes from '@/components/manage/ToyMes.vue'
Vue.use(VueRouter)
const routes = [
  {
    path: '/home',
    name: 'Home',
    component: Home,
    //home页面不需要被访问
    redirect: '/index2',
    children: [
      {
        path: '/index2',
        name: 'Admin',
        component: Admin,
        //为了区分页面是否需要拦截，在需要拦截的路由中加一条元数据
        meta: {
          requireAuth: true
        }
      },
      {
        path:'/toy',
        name:'ToyIndex',
        component: ToyIndex,
        meta: {
          requireAuth:true
        }
      },
      {
        path:'/mine',
        name:'MineIndex',
        component: MineIndex,
        children:[
          {
            path:'/mes',
            name:'Mes',
            component:Mes,
            meta: {
              requireAuth:true
            }
          },
          {
            path:'/mypost',
            name:'MyPost',
            component:MyPost,
            meta: {
              requireAuth:true
            }
          },
          {
            path:'/myorder',
            name:'MyOrder',
            component:MyOrder,
            meta:{
              requireAuth:true
            }
          },
          {
            path:'/sell',
            name:'MySell',
            component:MySell,
            meta:{
              requireAuth:true
            }
          }
        ],
        meta: {
          requireAuth:true
        }
      },
    ]
  },
  {
    path: '/home2',
    name: 'Home2',
    component: Home2,
    //home页面不需要被访问
    redirect: '/index',
    children: [
      {
        path: '/index',
        name:'AppIndex',
        component: AppIndex,
        meta: {
          requireAuth: true
        }
      },
      {
        path:'/toy1',
        name:'ToyIndex',
        component: ToyIndex,
        meta: {
          requireAuth:true
        }
      },
      {
        path:'/manage1',
        name:'ManageIndex',
        component: ManageIndex,
        children:[{
          path:'/man',
          name:'Manage',
          component:Manage,
        },
        {
          path:'/toymes',
          name:'ToysMes',
          component: ToyMes,
        }],
        meta: {
          requireAuth:true
        }
      },
      {
        path:'/mine1',
        name:'MineIndex2',
        component: MineIndex2,
        children:[
          {
            path:'/mes1',
            name:'Mes',
            component:Mes,
            meta: {
              requireAuth:true
            }
          },
          {
            path:'/mypost1',
            name:'MyPost',
            component:MyPost,
            meta: {
              requireAuth:true
            }
          },
          {
            path:'/myorder1',
            name:'MyOrder',
            component:MyOrder,
            meta: {
              requireAuth:true
            }
          },
          {
            path:'/sell1',
            name:'MySell',
            component:MySell,
            meta:{
              requireAuth:true
            }
          }
        ],
        meta: {
          requireAuth:true
        }
      },
    ]
  },
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
