package org.thoersch.poc.kotlin.rest

import org.springframework.web.bind.annotation.*
import org.thoersch.poc.kotlin.data.UserRepository
import org.thoersch.poc.kotlin.domain.Book

@RestController
@RequestMapping("/users/{id}/books")
class UsersBooksController(private val users: UserRepository) : BaseController() {

    @GetMapping
    fun getUsersBooks(@PathVariable id: Long): MutableList<Book> {
        val user = users.findOne(id) ?: throw IllegalArgumentException("Invalid User")
        return user.books
    }

    @PutMapping()
    fun acquireBook(@PathVariable id: Long, @RequestBody book: Book) : MutableList<Book> {
        val user = users.findOne(id) ?: throw IllegalArgumentException("Invalid User")
        user.books.add(book)
        return users.save(user).books
    }

    @DeleteMapping("/{bookId}")
    fun removeBook(@PathVariable id: Long, @PathVariable bookId: Long) : MutableList<Book> {
        val user = users.findOne(id) ?: throw IllegalArgumentException("Invalid User")
        user.books.removeIf { book: Book -> book.id == bookId }
        users.save(user)
        return user.books
    }
}
