package com.example.a2apiproject_kelasindustri.ui.paging

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.crocodic.core.api.ApiObserver
import com.crocodic.core.api.ApiResponse
import com.crocodic.core.api.DataObserver
import com.crocodic.core.data.CoreSession
import com.crocodic.core.extension.toList
import com.example.a2apiproject_kelasindustri.api.ApiService
import com.example.a2apiproject_kelasindustri.base.activity.BaseViewModel
import com.example.a2apiproject_kelasindustri.data.model.Article
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject


@HiltViewModel
class PagingViewModel @Inject constructor(
    private val apiService: ApiService,
    private val session: CoreSession,
    private val gson: Gson
) : BaseViewModel(apiService) {

    val articles = MutableLiveData<DataObserver<Article>>()

    fun listArticle(page: Int = 1) = viewModelScope.launch {
        apiResponse.postValue(ApiResponse().responseLoading(flag = page))
        apiService.listArticle(page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ApiObserver(true) {
                override fun onSuccess(t: String) {
                    val responseJson = JSONObject(t)

                    val apiStatus = responseJson.getInt("api_status")
                    val apiMessage = responseJson.getString("api_message")

                    if (apiStatus == 1) {
                        val apiData = responseJson.getJSONObject("data")
                        val datum = apiData.getJSONArray("article").toList<Article>(gson)
                        articles.postValue(DataObserver(page, datum))
                    }
                    apiResponse.postValue(ApiResponse().response(apiStatus, apiMessage))
                }
            })
    }
}