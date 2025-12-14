//引入创建应用的方法
import { createApp } from 'vue'

//倒入CSS
import './style/NavStyle.css'
import './style/ViewStyle.css'

//倒入并创建APP
import App from "./App.vue"
//import AppNav from './components/Nav.vue'
//import AppView from './components/View.vue'

//挂载app到制定Div中
//createApp(AppNav).mount('#Nav')
//createApp(AppView).mount('#View')
createApp(App).mount('#App')