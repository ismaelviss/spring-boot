package com.ismaelviss.springboot.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "post")
class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true)
    var id: Long = 0

    @Column(name = "description")
    var description: String = ""

    @ManyToOne
    @JsonBackReference(value = "user")
    var user: User? = null
}