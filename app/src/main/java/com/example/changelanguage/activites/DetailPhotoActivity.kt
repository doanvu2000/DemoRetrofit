package com.example.changelanguage.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.changelanguage.R
import com.example.changelanguage.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_photo.*

class DetailPhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_photo)
        initView()
    }

    private fun initView() {
        val photo = intent.getParcelableExtra<Photo>("photo")
        tvIdDetail.text = "${photo?.id}"
        tvUrlDetail.text = photo?.url
        tvTitleDetail.text = photo?.title
        Picasso.get().load(photo?.url).into(imageDetail)
    }
}