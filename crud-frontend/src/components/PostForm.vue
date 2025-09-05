<template>
  <div class="mb-4">
    <h2 class="text-xl font-bold mb-2">{{ isEdit ? 'Edit Post' : 'New Post' }}</h2>
    <form @submit.prevent="handleSubmit" class="flex flex-col space-y-2">
      <input v-model="form.title" placeholder="Title" class="border p-2" />
      <textarea v-model="form.content" placeholder="Content" class="border p-2"></textarea>
      <button type="submit" class="bg-blue-500 text-white px-4 py-2">
        {{ isEdit ? 'Update' : 'Create' }}
      </button>
    </form>
  </div>
</template>

<script>
import api from '../api'

export default {
  name: 'PostForm',
  props: {
    post: { type: Object, default: null }
  },
  data() {
    return {
      form: { title: '', content: '' }
    }
  },
  computed: {
    isEdit() {
      return !!this.post
    }
  },
  watch: {
    post: {
      immediate: true,
      handler(newVal) {
        if (newVal) this.form = { ...newVal }
      }
    }
  },
  methods: {
    async handleSubmit() {
      if (this.isEdit) {
        await api.put(`/posts/${this.post.id}`, this.form)
      } else {
        await api.post('/posts', this.form)
      }
      this.$emit('saved') // notify parent to refresh list
      this.form = { title: '', content: '' }
    }
  }
}
</script>
