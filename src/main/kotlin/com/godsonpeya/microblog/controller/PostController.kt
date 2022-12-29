package com.godsonpeya.microblog.controller

import com.godsonpeya.microblog.entity.Post
import com.godsonpeya.microblog.service.PostService
import com.godsonpeya.microblog.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController @Autowired constructor(private val postService: PostService) {
    @GetMapping("/posts")
    fun getPostList(): List<Post> = postService.getPosts()

    @GetMapping("/posts/by-user/{userId}")
    fun getPostsByUserId(@PathVariable userId: Long): List<Post> = postService.getPostByUserId(userId)

    @GetMapping("/posts/{id}")
    fun getUser(@PathVariable id: Long): Post = postService.getOne(id)

    @PostMapping("/posts")
    fun createUser(@RequestBody post: Post): Post = postService.savePost(post)

    @PutMapping("/posts/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody post: Post): Post = postService.updatePost(id, post)

    @DeleteMapping("/posts/{id}")
    fun deleteUser(@PathVariable id: Long): String = postService.deletePost(id)
}