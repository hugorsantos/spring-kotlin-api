package br.com.spring_kotlin_api.repository

import br.com.spring_kotlin_api.entities.Book
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CoroutineCrudRepository<Book, Long?> {

    @Query("SELECT * FROM books WHERE title = :title")
    suspend fun findbyTitlte(title: String): List<Book>
}