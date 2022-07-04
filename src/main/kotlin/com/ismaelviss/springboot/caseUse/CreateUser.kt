package com.ismaelviss.springboot.caseUse

import com.ismaelviss.springboot.entity.User
import com.ismaelviss.springboot.service.UserService
import org.springframework.stereotype.Component

@Component
class CreateUser(
    private val userService: UserService
) {
    fun save(newUser: User): User {
        return userService.save(newUser)
    }
}