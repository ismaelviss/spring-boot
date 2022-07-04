package com.ismaelviss.springboot.repository

import com.ismaelviss.springboot.dto.UserDto
import com.ismaelviss.springboot.entity.User
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {

    //query jpql
    @Query("select u from User u where u.email=?1")
    fun findUserByEmail(email: String) : Optional<User>

    //query jpql
    @Query("select u from User u where lower(u.name) like %?1%")
    fun findUsersByNameAndOrderBy(name: String, sort: Sort) : List<User>

    //query method
    fun findUserByName(name: String) : Optional<User>

    fun findUsersByNameLike(name: String) : List<User>

    fun findByEmailOrName(email: String?, name: String?) : Optional<User>

    fun findUsersByBirtDateBetween(begin: LocalDate, end: LocalDate) : List<User>

    fun findUsersByNameLikeOrderById(name: String) : List<User>

    fun findUsersByNameContainingOrderById(name: String) : List<User>

    //named params
    @Query("SELECT new com.ismaelviss.springboot.dto.UserDto(u.id, u.name, u.birtDate)" +
            " from User u" +
            " where u.birtDate=:parametroFecha" +
            " and u.email=:parametroEmail"
    )
    fun getAllByBirthDateAndEmail(@Param("parametroFecha") date: LocalDate, @Param("parametroEmail") email: String) : Optional<UserDto>
}