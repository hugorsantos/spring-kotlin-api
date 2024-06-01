package br.com.spring_kotlin_api.dto

import br.com.spring_kotlin_api.entities.Book

fun BookRequest.toBook(): Book {
    return Book(
            title = this.title,
            status = this.status
    )
}

fun Book.toBookResponse(): BookResponse {
    return BookResponse(
            id = this.id!!,
            title = this.title,
            status = this.status
    )
}
