package org.techtown.databindingexample

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {

    //Glide 라이브러리 추가
    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(imageView :ImageView ,url : String){
        Glide.with(imageView.context).load(url)
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}