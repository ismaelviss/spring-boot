package com.ismaelviss.springboot.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.time.LocalDate
import javax.persistence.*
import kotlin.coroutines.CoroutineContext

@Entity
@Table(name = "t_user")
class User() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false, unique = true)
    var id: Long? = null

    @Column(length = 50)
    var name: String? =null

    @Column(length = 50, unique = true)
    var email: String? = null

    @Column(name = "birth_date")
    var birtDate: LocalDate? = null

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    //@JsonManagedReference(value = "posts")
    var posts: List<Post>? = null

    constructor(name: String, email: String, birtDate: LocalDate) : this() {
        this.name = name
        this.email = email
        this.birtDate = birtDate
    }

    constructor(id: Long) : this() {
        this.id = id
    }

    override fun toString(): String {
        return "User(id=$id, name=$name, email=$email, birtDate=$birtDate, posts=$posts)"
    }
}
