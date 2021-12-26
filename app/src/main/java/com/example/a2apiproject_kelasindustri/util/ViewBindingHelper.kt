package com.example.a2apiproject_kelasindustri.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ViewBindingHelper {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["imageUrl", "imageThumbnail"], requireAll = false)
        fun loadImage(view: ImageView, imageUrl: String?, imageThumbnail: String?) {
            imageUrl?.let {

                val thumbnail = Glide
                    .with(view.context)
                    .load(imageThumbnail)
                    .apply(RequestOptions.centerCropTransform())


                Glide
                    .with(view.context)
                    .load(imageUrl)
                    .thumbnail(thumbnail)
                    .apply(RequestOptions.centerCropTransform())
                    .into(view)
            }
        }
    }
}