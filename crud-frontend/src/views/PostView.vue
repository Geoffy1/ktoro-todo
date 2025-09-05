<template>
  <div class="p-4">
    <PostForm :post="selectedPost" @saved="refreshList" />
    <PostList @edit="setEditPost" ref="list" />
  </div>
</template>

<script>
import PostForm from '../components/PostForm.vue'
import PostList from '../components/PostList.vue'

export default {
  components: { PostForm, PostList },
  data() {
    return { selectedPost: null }
  },
  methods: {
    setEditPost(post) {
      this.selectedPost = post
    },
    refreshList() {
      this.selectedPost = null
      this.$refs.list.fetchPosts()
    }
  }
}
</script>
