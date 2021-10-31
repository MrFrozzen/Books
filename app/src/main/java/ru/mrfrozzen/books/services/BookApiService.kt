package ru.mrfrozzen.books.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookApiService {

    companion object {
        private const val BASE_URL = "https://demo.api-platform.com"
        private var retrofit : Retrofit? = null

        fun getInstance() : Retrofit{
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return  retrofit!!
        }
    }
}