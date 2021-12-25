package com.example.a2apiproject_kelasindustri.ui.paging

import android.os.Bundle
import com.crocodic.core.base.adapter.CoreListAdapter
import com.crocodic.core.base.adapter.CoreListAdapter.Companion.get
import com.crocodic.core.extension.initLoadMore
import com.crocodic.core.extension.openActivity
import com.crocodic.core.helper.list.EndlessScrollListener
import com.example.a2apiproject_kelasindustri.R
import com.example.a2apiproject_kelasindustri.base.activity.BaseActivity
import com.example.a2apiproject_kelasindustri.data.constant.Const
import com.example.a2apiproject_kelasindustri.data.model.Article
import com.example.a2apiproject_kelasindustri.databinding.ActivityPagingBinding
import com.example.a2apiproject_kelasindustri.databinding.ItemArticleBinding
import com.example.a2apiproject_kelasindustri.ui.detail.DetailArticleActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PagingActivity : BaseActivity<ActivityPagingBinding, PagingViewModel>() {

    private var articlesList: ArrayList<Article?> = ArrayList()
    private var scrollListener: EndlessScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutRes(R.layout.activity_paging)

        getData()
        initView()
        observe()

    }

    private fun getData(page: Int = 1) {
        viewModel.listArticle(page = page)
    }

    private fun initView() {
        binding.rvArticle.adapter =
            CoreListAdapter<ItemArticleBinding, Article>(R.layout.item_article).initItem(
                articlesList
            ) { position, data ->
                openActivity<DetailArticleActivity> {
                    putExtra(Const.BUNDLE.ARTICLE, data)
                }
            }


        scrollListener = binding.rvArticle.initLoadMore { page ->
            getData(page + 1)
            binding.rvArticle.adapter?.get()?.addNull()
        }
    }


    private fun observe() {
        viewModel.articles.observe(this, {
            binding.rvArticle.adapter?.get()?.removeNull()

            if (it.page == 1) {
                articlesList.clear()
                binding.rvArticle.adapter?.notifyDataSetChanged()
                scrollListener?.resetState()
            }

            if (it.datas.isNotEmpty()) {
                if (binding.rvArticle.adapter?.itemCount == 0) {
                    articlesList.addAll(it.datas)
                    binding.rvArticle.adapter?.notifyItemInserted(0)
                } else {
                    articlesList.addAll(it.datas)
                    binding.rvArticle.adapter?.notifyItemInserted(
                        binding.rvArticle.adapter?.itemCount ?: 1 - 1
                    )
                }
            }
        })
    }

}