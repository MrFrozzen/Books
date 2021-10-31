package ru.mrfrozzen.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.book_item.view.*
import ru.mrfrozzen.books.models.Book

class BookAdapter (
    private val books : List<Book>
    ) : RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

        class BookViewHolder(view : View) : RecyclerView.ViewHolder(view) {

            fun bindBook(book: Book) {
            itemView.book_title.text = book.title
            itemView.book_author.text = book.author
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindBook(books.get(position))
    }

    override fun getItemCount(): Int = books.size
}