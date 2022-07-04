package com.ismaelviss.springboot.repository

import com.ismaelviss.springboot.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long> {
}