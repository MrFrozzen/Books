package ru.mrfrozzen.books.services

import retrofit2.Call
import retrofit2.http.GET
import ru.mrfrozzen.books.models.BookResponce

interface BookApiInterface {

    @GET("/books")
    fun getBookList(): Call<BookResponce>
}