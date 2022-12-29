package com.godsonpeya.microblog.service

import com.godsonpeya.microblog.entity.Post
import com.godsonpeya.microblog.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(private var postRepository: PostRepository) {
    fun getPosts(): List<Post> = postRepository.findAll()

    fun getPostByUserId(userId: Long): List<Post> = postRepository.findAllByUserId(userId)
    fun getOne(id: Long): Post =
        postRepository.findById(id).orElseThrow { IllegalArgumentException("Post with id = $id was not found") }

    fun savePost(post: Post): Post = postRepository.save(post)
    fun updatePost(id: Long, postInput: Post): Post {
        val postFound = getOne(id)
        postFound.content = postInput.content
        return postRepository.save(postFound)
    }

    fun deletePost(id: Long): String {
        val postFound = getOne(id)

        postRepository.delete(postFound)

        return "post deleted"
    }
}