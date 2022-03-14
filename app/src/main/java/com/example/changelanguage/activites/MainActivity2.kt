package com.example.changelanguage.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.changelanguage.R
import com.example.changelanguage.adapter.PhotoAdapter
import com.example.changelanguage.viewmodel.PhotoViewModel
import kotlinx.android.synthetic.main.activity_main2.*

private const val TAG = "MainActivity2"

class MainActivity2 : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[PhotoViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val layout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel.getPhotos {

        }
        viewModel.photoList.observe(this){
            val photoAdapter = PhotoAdapter(it)
            rcvPhoto.layoutManager = layout
            rcvPhoto.adapter = photoAdapter
        }
    }

}
