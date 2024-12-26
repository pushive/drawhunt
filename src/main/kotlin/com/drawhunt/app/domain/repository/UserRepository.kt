package com.drawhunt.app.domain.repository

import com.drawhunt.app.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun findByEmailAddress(emailAddress: String): User?
    fun findByConfirmationToken(token: String): User?
}