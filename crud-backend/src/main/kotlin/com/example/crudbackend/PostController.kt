package com.example.crudbackend

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts")
class PostController(private val repository: PostRepository) {

    // ✅ Get all posts
    @GetMapping
    fun getAllPosts(): List<Post> = repository.findAll()

    // ✅ Get a single post by ID
    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): Post =
        repository.findById(id).orElseThrow { RuntimeException("Post not found with id $id") }

    // ✅ Create a new post
    @PostMapping
    fun createPost(@RequestBody post: Post): Post = repository.save(post)

    // ✅ Update an existing post
    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody updatedPost: Post): Post {
        val existingPost = repository.findById(id)
            .orElseThrow { RuntimeException("Post not found with id $id") }

        val postToSave = existingPost.copy(
            title = updatedPost.title,
            content = updatedPost.content
        )
        return repository.save(postToSave)
    }

    // ✅ Delete a post
    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long) {
        if (!repository.existsById(id)) {
            throw RuntimeException("Post not found with id $id")
        }
        repository.deleteById(id)
    }
}
