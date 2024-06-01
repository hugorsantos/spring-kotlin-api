package br.com.spring_kotlin_api.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "books")
data class Book(
        @Id
        val id: Long? = null,
        val title: String,
        val status: Boolean
)
