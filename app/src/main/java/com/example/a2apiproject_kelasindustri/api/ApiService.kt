package com.example.a2apiproject_kelasindustri.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("webs/list-article")
    fun listArticle(
        @Query("pagr") page: Int?
    ): Single<String>
}