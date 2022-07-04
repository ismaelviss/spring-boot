package com.ismaelviss.springboot.caseUse

import com.ismaelviss.springboot.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface GetUser {
    fun getAll() : List<User>
    fun getUser(id: Long): User
    fun findAll(page: Int, size: Int): List<User>
    fun findAll2(pageable: Pageable): Page<User>
}