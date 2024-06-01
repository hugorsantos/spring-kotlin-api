package br.com.spring_kotlin_api.dto

data class BookResponse (
        val id: Long,
        val title: String,
        val status: Boolean
)