package com.example.nyapp.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nyapp.R
import com.example.nyapp.data.model.Book

class BooksAdapter(
    private val books: List<Book>
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BooksViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
        viewHolder.bindView(books[position])
    }

    override fun getItemCount(): Int {
        return books.count()
    }

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.findViewById<TextView>(R.id.textTitle)
        private val author = itemView.findViewById<TextView>(R.id.textAuthor)

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author
        }
    }
}
