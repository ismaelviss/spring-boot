package com.ismaelviss.springboot.caseUse

import com.ismaelviss.springboot.entity.User
import com.ismaelviss.springboot.service.UserService
import org.springframework.stereotype.Component

@Component
class UpdateUser(
    private val userService: UserService
) {
    fun save(id: Long, newUser: User): User {
        return userService.update(id, newUser)
    }

}