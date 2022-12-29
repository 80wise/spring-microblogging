package com.godsonpeya.microblog.repository

import com.godsonpeya.microblog.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository:JpaRepository<User, Long> {
    fun findByUsername(username: String): Optional<User>
}