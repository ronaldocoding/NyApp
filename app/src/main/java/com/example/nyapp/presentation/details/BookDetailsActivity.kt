package com.example.nyapp.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nyapp.R
import com.example.nyapp.databinding.ActivityBookDetailsBinding

class BookDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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