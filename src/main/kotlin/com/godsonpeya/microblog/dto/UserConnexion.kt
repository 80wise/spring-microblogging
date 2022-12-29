package com.godsonpeya.microblog.dto

import org.hibernate.validator.constraints.NotBlank
import javax.validation.constraints.Size


data class UserConnexion(
    @field:NotBlank(message = "username can't be blank")
    var username: String,
    @field:NotBlank(message = "password is required")
    @field:Size(min = 6)
    var password: String
) {

}