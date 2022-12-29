package com.godsonpeya.microblog.repository

import com.godsonpeya.microblog.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PostRepository:JpaRepository<Post, Long> {
    fun findAllByUserId(userId: Long):List<Post>
}