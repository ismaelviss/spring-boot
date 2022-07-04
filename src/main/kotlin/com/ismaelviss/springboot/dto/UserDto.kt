package com.ismaelviss.springboot.dto

import java.time.LocalDate

class UserDto(
    var id: Long? = null,
    var name: String? = null,
    var birthDate: LocalDate? = null
) {
    override fun toString(): String {
        return "UserDto(id=$id, name=$name, birthDate=$birthDate)"
    }
}