import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PostView from '../views/PostView.vue'

const routes = [
  { path: '/', component: HomeView },
  { path: '/posts', component: PostView }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
