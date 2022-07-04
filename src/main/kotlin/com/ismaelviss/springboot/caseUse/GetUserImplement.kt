package com.ismaelviss.springboot.caseUse

import com.ismaelviss.springboot.entity.User
import com.ismaelviss.springboot.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

class GetUserImplement(
    private val userService: UserService
) : GetUser {
    override fun getAll(): List<User> {
        return userService.getAllUsers()
    }

    override fun getUser(id: Long): User {
        return userService.getUser(id)
    }

    override fun findAll(page: Int, size: Int): List<User> {
        return userService.findAll(page, size)
    }

    override fun findAll2(pageable: Pageable): Page<User> {
        return userService.findAll2(pageable)
    }
}