package org.thoersch.poc.kotlin.data

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.thoersch.poc.kotlin.domain.User

interface UserRepository : CrudRepository<User, Long> {
    @Query("select u from User u left join fetch u.books")
    fun findAllWithBooks() : Iterable<User>
}
