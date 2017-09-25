package org.thoersch.poc.kotlin.domain

import org.hibernate.validator.constraints.Length
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
data class Book (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        @NotNull
        var title: String = "",
        @NotNull
        var author: String = "",
        @NotNull @Length(max = 20)
        var isbn: String = ""
)
