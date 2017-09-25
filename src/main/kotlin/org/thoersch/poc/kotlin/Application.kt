package org.thoersch.poc.kotlin

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.thoersch.poc.kotlin.data.BookRepository
import org.thoersch.poc.kotlin.data.UserRepository
import org.thoersch.poc.kotlin.domain.Book
import org.thoersch.poc.kotlin.domain.User
import java.util.*

@SpringBootApplication
class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    fun init(users: UserRepository, books: BookRepository) = CommandLineRunner {
        val mockUsers = arrayOf(User(0, "Tyler", "Hoersch", "tyler.hoersch@virginpulse.com"),
                                User(0, "Tommy", "Harke", "thomas.harke@virginpulse.com"),
                                User(0, "Josh", "Van Gomple", "joshua.van.gomple@virginpulse.com"),
                                User(0, "Justin", "Doehling", "justin.doehling@virginpulse.com"),
                                User(0, "Austin", "Baldwin", "austin.baldwin@virginpulse.com"),
                                User(0, "Jacob", "Johansen", "jacob.johansen@virginpulse.com"),
                                User(0, "Phil", "Fleischer", "phil.fleischer@virginpulse.com"),
                                User(0, "Matt", "Stangel", "matthew.stangel@virginpulse.com"),
                                User(0, "Jerry", "Saravia", "jerry.saravia@virginpulse.com"))

        log.info("Bootstrapping ${mockUsers.size} users...")

        mockUsers.forEach { user: User -> users.save(user) }
        users.findAll().forEach { user: User -> log.info("User found: ${user.firstName}") }

        val mockBooks = arrayOf(Book(0, "IT", "Stephen King",  "123456789123456789"),
                                Book(0, "The Gunslinger", "Stephen King", "9826384623234"),
                                Book(0, "The Drawing of Three", "Stephen King", "2342384762934"),
                                Book(0, "The Wastelands", "Stephen King", "122342342342343"),
                                Book(0, "Wizard and the Glass",  "Stephen King", "389342348234"),
                                Book(0, "The Wolves of the Calla", "Stephin King", "132482734623"))

        log.info("Bootstrapping ${mockBooks.size} books...")

        mockBooks.forEach { book: Book -> books.save(book) }
        books.findAll().forEach { book: Book -> log.info("Book Found: ${book.title}") }

        log.info("Adding random books to users...")
        val library = books.findAll()
        users.findAllWithBooks().forEach { user: User ->
            library.forEach { book: Book ->
                if(Random().nextBoolean()) {
                    user.books.add(book)
                }
            }
            users.save(user)
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
