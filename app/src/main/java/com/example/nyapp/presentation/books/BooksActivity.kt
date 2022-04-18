package com.example.nyapp.presentation.books

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nyapp.R
import com.example.nyapp.databinding.ActivityBooksBinding
import com.example.nyapp.presentation.base.BaseActivity
import com.example.nyapp.presentation.details.BookDetailsActivity

class BooksActivity : BaseActivity() {

    private lateinit var booksBinding: ActivityBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        booksBinding = ActivityBooksBinding.inflate(layoutInflater)
        val view = booksBinding.root
        setContentView(view)

        setupToolbar(findViewById(R.id.toolbarMain), R.string.books_title)

        val viewModel = ViewModelProvider(this).get(BooksViewModel::class.java)
        viewModel.booksLiveData.observe(this) {
            it?.let { books ->
                with(booksBinding.recyclerviewBooks) {
                    layoutManager =
                        LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books) { book ->
                        val intent = BookDetailsActivity.getStartIntent(this@BooksActivity, book.title, book.description)
                        this@BooksActivity.startActivity(intent)
                    }
                }
            }
        }
        viewModel.viewFlipperLiveData.observe(this) {
            it?.let { viewFlipper ->
                booksBinding.viewFlipperBooks.displayedChild = viewFlipper.first
                viewFlipper.second?.let { errorMessageResId ->
                    booksBinding.textViewError.text = getString(errorMessageResId)
                }
            }
        }

        viewModel.getBooks()
    }
}