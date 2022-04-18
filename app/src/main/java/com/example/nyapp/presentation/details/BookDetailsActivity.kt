package com.example.nyapp.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.nyapp.R
import com.example.nyapp.databinding.ActivityBookDetailsBinding
import com.example.nyapp.presentation.base.BaseActivity

class BookDetailsActivity : BaseActivity() {

    private lateinit var binding: ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupToolbar(findViewById(R.id.toolbarMain), R.string.book_details_title, true)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)

        binding.bookDetailsTitle.text = title
        binding.bookDetailsDescription.text = description
    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(context: Context, title: String, description: String): Intent {
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}