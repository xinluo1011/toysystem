import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

//前端拦截器方法
export default new Vuex.Store({
    state: {
        user: {
            id:window.localStorage.getItem('user' || '[]')==null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).id,
            username: window.localStorage.getItem('user' || '[]')==null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username
        }
    },
    mutations: {
        login(state,user) {
            state.user =user
            // localStorage本地存储，在项目打开时会判断本地存储是否有user这个对象存在
            //如果存在就取出来并获得username的值，否则把username设置为空
            window.localStorage.setItem('user',JSON.stringify(user))
        }
    }
})