package com.ismaelviss.springboot.controller

import com.ismaelviss.springboot.caseUse.CreateUser
import com.ismaelviss.springboot.caseUse.DeleteUser
import com.ismaelviss.springboot.caseUse.GetUser
import com.ismaelviss.springboot.caseUse.UpdateUser
import com.ismaelviss.springboot.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserRestController(
    private val getUser: GetUser,
    private val createUser: CreateUser,
    private val deleteUser: DeleteUser,
    private val updateUser: UpdateUser
) {

    @GetMapping
    fun get() : List<User> {
        return getUser.getAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) : User {
        return getUser.getUser(id)
    }

    @GetMapping("/pageable")
    fun getUsersPageable(@RequestParam page: Int, @RequestParam size: Int) : List<User> {
        return getUser.findAll(page, size)
    }

    @GetMapping("/pageable2")
    fun getUsersPageable2(@PageableDefault(page = 0, size = 2) pageable: Pageable) : Page<User> {
        return getUser.findAll2(pageable)
    }

    @PostMapping
    fun newUser(@RequestBody newUser: User) : ResponseEntity<User> {
        return ResponseEntity<User>(createUser.save(newUser), HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) : ResponseEntity<Any> {
        deleteUser.remove(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody newUser: User) : ResponseEntity<User> {
        return ResponseEntity<User>(updateUser.save(id, newUser), HttpStatus.OK)
    }
}