package com.drawhunt.app.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "username", nullable = false, unique = true)
    var username: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "email_address", nullable = false, unique = true)
    var emailAddress: String,

    @Column(name = "is_confirmed", nullable = false)
    var isConfirmed: Boolean = false,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime,
)