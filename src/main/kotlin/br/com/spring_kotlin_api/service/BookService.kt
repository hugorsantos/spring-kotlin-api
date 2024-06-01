package br.com.spring_kotlin_api.service

import br.com.spring_kotlin_api.entities.Book
import br.com.spring_kotlin_api.repository.BookRepository
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class BookService (
   private val bookRepository: BookRepository
) {

    suspend fun save(book: Book): Book {
        return bookRepository.save(book)
    }

    suspend fun findAll(): List<Book> {
        return bookRepository.findAll().toList()
    }

    suspend fun findById(id: Long): Book {
        return bookRepository.findById(id) ?: throw Exception("Not found")
    }

    suspend fun findByTitle(title: String): List<Book> {
        return bookRepository.findbyTitlte(title)
    }

    suspend fun deleteById(id: Long) {
        return bookRepository.deleteById(id)
    }
}