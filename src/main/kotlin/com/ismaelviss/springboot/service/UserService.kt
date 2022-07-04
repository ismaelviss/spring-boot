package com.ismaelviss.springboot.service

import com.ismaelviss.springboot.entity.User
import com.ismaelviss.springboot.repository.UserRepository
import org.apache.commons.logging.LogFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    private val log = LogFactory.getLog(UserService::class.java)

    // la anotacion transaccional no permite aplicar el principio de atomicidad, se aplica la tarea o se reversa
    @Transactional
    fun saveTransactional(users: List<User>) {
            users.stream()
                .peek { user -> log.info(user) }
                .forEach(userRepository::save)
    }

    fun getAllUsers() : List<User> {
        return userRepository.findAll()
    }

    fun save(newUser: User) : User {
        return userRepository.save(newUser)
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }

    fun update(id: Long, newUser: User): User {
        return userRepository.findById(id)
            .map {
                it.email = newUser.email
                it.name = newUser.name
                it.birtDate = newUser.birtDate
                userRepository.save(it)
            }.get()
    }

    fun getUser(id: Long): User {
        return userRepository.findById(id).get()
    }

    fun findAll(page: Int, size: Int): List<User> {
        return userRepository.findAll(PageRequest.of(page, size)).content
    }

    fun findAll2(pageable: Pageable): Page<User> {
        return userRepository.findAll(pageable)
    }
}