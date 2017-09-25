package org.thoersch.poc.kotlin.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.thoersch.poc.kotlin.data.BookRepository

@RestController
@RequestMapping("/books")
class BooksController(private val books: BookRepository) : BaseController() {
    @GetMapping
    fun getBooks() = books.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = books.findOne(id)
}
