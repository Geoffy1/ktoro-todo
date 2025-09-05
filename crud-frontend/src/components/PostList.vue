<template>
  <div>
    <h2 class="text-xl font-bold mb-2">Posts</h2>
    <ul>
      <li v-for="post in posts" :key="post.id" class="mb-2 border p-2">
        <h3 class="font-semibold">{{ post.title }}</h3>
        <p>{{ post.content }}</p>
        <button @click="$emit('edit', post)" class="mr-2 bg-yellow-500 text-white px-2 py-1">Edit</button>
        <button @click="deletePost(post.id)" class="bg-red-500 text-white px-2 py-1">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script>
import api from '../api'

export default {
  name: 'PostList',
  data() {
    return { posts: [] }
  },
  methods: {
    async fetchPosts() {
  try {
    const res = await api.get('/posts')
    this.posts = res.data
  } catch (error) {
    console.error("Failed to fetch posts:", error)
    // Display a user-friendly error message here
  }
},
    async deletePosts(id) {
  try {
    const res = await api.get('/posts')
    this.posts = res.data
  } catch (error) {
    console.error("Failed to delete posts:", error)
    // Display a user-friendly error message here
  }
}
  },
  mounted() {
    this.fetchPosts()
  }
}
</script>
