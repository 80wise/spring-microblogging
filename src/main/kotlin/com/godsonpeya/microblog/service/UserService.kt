package com.godsonpeya.microblog.service

import com.godsonpeya.microblog.dto.UserConnexion
import com.godsonpeya.microblog.entity.User
import com.godsonpeya.microblog.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService @Autowired constructor(private var userRepository: UserRepository) {

    fun getUsers(): List<User> = userRepository.findAll()

    fun getOne(id: Long): User =
        userRepository.findById(id).orElseThrow { IllegalArgumentException("User with id = $id was not found") }

    fun saveUser(user: User): User = userRepository.save(user)  //TODO validate data

    fun updateUser(id: Long, userInput: User): User {
        val userFound = getOne(id)

        userFound.username = userInput.username
        userFound.profession = userInput.profession
        userFound.ville = userInput.ville
        userFound.pays = userInput.pays
        userFound.fullname = userInput.fullname
        userFound.password = userInput.password

        return userRepository.save(userFound)
    }

    fun deleteUser(id: Long): String {
        val userFound = getOne(id)

        userRepository.delete(userFound)
        return "User deleted"
    }

    fun login(user: UserConnexion): User {
        val userFound =
            userRepository.findByUsername(user.username).orElseThrow { IllegalArgumentException("User not found") }
        if (userFound.password == user.password) {
            return userFound
        }
        throw IllegalArgumentException("wrong password")
    }
}