package com.example.a2apiproject_kelasindustri.ui.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.crocodic.core.base.activity.NoViewModelActivity
import com.example.a2apiproject_kelasindustri.R
import com.example.a2apiproject_kelasindustri.data.constant.Const
import com.example.a2apiproject_kelasindustri.data.model.Article
import com.example.a2apiproject_kelasindustri.databinding.ActivityDetailArticleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailArticleActivity : NoViewModelActivity<ActivityDetailArticleBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutRes(R.layout.activity_detail_article)

        //Ketika Cara pendek dalam get Data nya
        binding.data = intent.getParcelableExtra(Const.BUNDLE.ARTICLE)

        //Ketika Cara panjang dalam get Data nya
//        val article: Article? = intent.getParcelableExtra(Const.BUNDLE.ARTICLE)
//        binding.data = article

        //Glide Image
    // Secara Manual di Activity
//        Glide
//            .with(this)
//            .load(article?.image)
//            .apply(RequestOptions.centerCropTransform())
//            .into(binding.ivArticle)


    }
}