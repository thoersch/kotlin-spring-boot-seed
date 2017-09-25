package org.thoersch.poc.kotlin.data

import org.springframework.data.repository.CrudRepository
import org.thoersch.poc.kotlin.domain.Book

interface BookRepository : CrudRepository<Book, Long>
