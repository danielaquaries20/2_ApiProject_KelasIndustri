package com.example.a2apiproject_kelasindustri.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ViewBindingHelper {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, imageUrl: String?) {
            imageUrl?.let {
                Glide
                    .with(view.context)
                    .load(imageUrl)
                    .apply(RequestOptions.centerCropTransform())
                    .into(view)
            }
        }
    }
}