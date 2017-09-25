package org.thoersch.poc.kotlin.rest

import org.springframework.web.bind.annotation.*
import org.thoersch.poc.kotlin.data.UserRepository
import org.thoersch.poc.kotlin.domain.User
import javax.validation.Valid
import javax.validation.constraints.NotNull

@RestController
@RequestMapping(value = "/users")
class UsersController(private val users: UserRepository) : BaseController() {
    @GetMapping()
    fun getUsers() = users.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = users.findOne(id)

    @PostMapping()
    fun addUser(@NotNull @Valid @RequestBody user: User) : User = users.save(user)
}
