package com.ismaelviss.springboot.caseUse

import com.ismaelviss.springboot.entity.User
import com.ismaelviss.springboot.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class DeleteUser(
    private val userService: UserService
) {
    fun remove(id: Long) {
        userService.deleteUser(id)
    }
}