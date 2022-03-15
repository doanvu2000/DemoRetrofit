package com.example.changelanguage.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.changelanguage.R
import com.example.changelanguage.adapter.PhotoAdapter
import com.example.changelanguage.model.Photo
import com.example.changelanguage.viewmodel.PhotoViewModel
import com.squareup.picasso.Picasso
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
        viewModel.getPhotos {}
        val data: MutableList<Photo> = ArrayList()
        viewModel.progressStatus.observe(this) {
            if (!it) {
                progressPhoto.visibility = View.VISIBLE
            } else {
                progressPhoto.visibility = View.INVISIBLE
            }
        }
        viewModel.photoList.observe(this) { it ->
            data.addAll(it)
            Log.d(TAG, "setUpRecyclerView: ${data.size}")
            val photoAdapter = PhotoAdapter(data)
            rcvPhoto.apply {
                layoutManager = layout
                adapter = photoAdapter
                addItemDecoration(
                    DividerItemDecoration(
                        baseContext,
                        DividerItemDecoration.VERTICAL
                    )
                )
            }
            photoAdapter.setOnClickItem {
                val intent = Intent(baseContext, DetailPhotoActivity::class.java)
                intent.putExtra("photo", data[it])
                startActivity(intent)
            }
        }
    }

}
