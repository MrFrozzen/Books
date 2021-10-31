package ru.mrfrozzen.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import ru.mrfrozzen.books.models.Book
import ru.mrfrozzen.books.models.BookResponce
import ru.mrfrozzen.books.services.BookApiInterface
import ru.mrfrozzen.books.services.BookApiService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_books_list.layoutManager = LinearLayoutManager(this)
        rv_books_list.setHasFixedSize(true)
        getBookData { books : List<Book> ->
            rv_books_list.adapter = BookAdapter(books)
        }
    }

    private fun getBookData(callback: (List<Book>) -> Unit) {
        val apiService = BookApiService.getInstance().create(BookApiInterface::class.java)
        apiService.getBookList().enqueue(object : Callback<BookResponce> {
            override fun onResponse(call: Call<BookResponce>, response: Response<BookResponce>) {
                return callback(response.body()!!.books)
            }

            override fun onFailure(call: Call<BookResponce>, t: Throwable) {

            }

        })
    }
}