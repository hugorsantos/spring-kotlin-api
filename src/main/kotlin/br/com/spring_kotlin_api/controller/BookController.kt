package br.com.spring_kotlin_api.controller

import br.com.spring_kotlin_api.dto.BookRequest
import br.com.spring_kotlin_api.dto.BookResponse
import br.com.spring_kotlin_api.dto.toBook
import br.com.spring_kotlin_api.dto.toBookResponse
import br.com.spring_kotlin_api.entities.Book
import br.com.spring_kotlin_api.service.BookService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/book")
class BookController (
        private val bookService: BookService
) {

    @PostMapping("/new")
    suspend fun save(@RequestBody book: BookRequest): BookResponse {
        return bookService.save(book.toBook()).toBookResponse()
    }

    @GetMapping
    suspend fun findAll(): List<BookResponse> {
        return bookService.findAll().map { it.toBookResponse() }
    }

    @GetMapping("/id/{id}")
    suspend fun findAll(@PathVariable id: Long): List<BookResponse> {
        return bookService.findAll().map { it.toBookResponse() }
    }

    @GetMapping("/title/{title}")
    suspend fun findAll(@PathVariable title: String): List<BookResponse> {
        return bookService.findByTitle(title).map { it.toBookResponse() }
    }

    @DeleteMapping("/id/{id}")
    suspend fun deleteById(@PathVariable id: Long) {
        return bookService.deleteById(id)
    }

}
