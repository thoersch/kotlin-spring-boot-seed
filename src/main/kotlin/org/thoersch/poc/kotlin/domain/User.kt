package org.thoersch.poc.kotlin.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class User (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val firstName: String = "",
        val lastName: String = "",
        val email: String = "",
        @ManyToMany @JsonIgnore
        var books: MutableList<Book> = mutableListOf()
)

