package com.example.taskmanage.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.taskmanage.R

fun ImageView.loadImage(url : String){
    Glide.with(this).load(url).placeholder(R.drawable.ic_profile).into(this)
}